import { Component, OnInit,ViewChild } from '@angular/core';
import { BillService } from '../../bill.service';
import { Bill } from '../../bill';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, FormArray, FormControl, ValidatorFn } from '@angular/forms';
import {ModalDirective} from 'ngx-bootstrap/modal';
import * as _ from 'lodash';
import { of } from 'rxjs';
import { analyzeAndValidateNgModules } from '@angular/compiler';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.scss']
})
export class CustomerFormComponent implements OnInit {

  readonly APP_URL = "http://localhost:8082/ERP-Company/";

  myresponse:any;
  myresponse1:any;
  i:number;
  valueee:any;
  checkedRoles:any;
  myresponse3:any;
  myresponse4:[];
  myresponse5:any;
  public fooData: any;
  j:number;
  private bill:Bill;
  myForm: FormGroup;
  merged1:any;
  megha1:any;
  constructor(private fb: FormBuilder,private router:Router,
    private http:HttpClient,private billService:BillService) { 
  
  }

  
  ngOnInit() {
    this.bill=this.billService.getter();
    console.log("bill",this.bill);
    console.log(this.bill.c_name);
    value:String;
    this.value=this.bill.c_id;
    this.http.get(this.APP_URL +'bill/save?value='+this.value).subscribe(
      result=>{
        this.myresponse3=result;
//         this.merged1 ={"Checked":"true"};
//         console.log("meghaaaa", this.myresponse3);
//         for(this.j=0;this.j<this.myresponse3.length;this.j++){
//           console.log("meghaaaa");
//         megha1: _.merge(this.myresponse3[this.j],this.merged1);
//         console.log(this.megha1.value);
// }
      },
      error=>{
        console.log("error Occured",error);
      }
    );
    this.createform();    
    // this.myForm = this.fb.group({
    //   p_names: this.fb.array([]),
    //   //size:([''])
    // });
  }

values: any;
myresponse2:any;
  createform()    
{    
  let arr=[];
  this.http.get(this.APP_URL +'bill/product').subscribe(
    result=>{
      this.myresponse1=result;
      console.log("myresponse1",this.myresponse1);
      for(let i=0;i<this.myresponse1.length;i++)    
      {       
        arr.push(this.BuildFormDynamic(this.myresponse1[i]))    
      }    
        this.myForm =  this.fb.group({    
          ClassDetails:this.fb.array(arr)  
        })  
    },
    error=>{
      console.log("error Occured",error);
    }
  );
  //console.log("myresponse1",this.myresponse1);
 // console.log("megha123",this.AllClassData);
  // for(let i=0;i<this.AllClassData.length;i++)    
  // {       
  //   arr.push(this.BuildFormDynamic(this.AllClassData[i]))    
  // }    
  //   this.myForm =  this.fb.group({    
  //     SchoolName : [''],    
  //     ClassDetails:this.fb.array(arr)  
  //   })    
}

SaveData()    
  {    
    console.log(this.myForm.value);  
  }   
    
BuildFormDynamic(product):FormGroup{    
 return this.fb.group({ 
      //values:this.myresponse3,
       Class:[product.p_name], 
      // Class1: this.fb.array([]),  
       size:[''],    
       rate:[''],   
       package:[''], 
       box:[''], 
       qty:['']
  })    
}    

  

   emailFormArray :any;
   value:any;
  // onChange(p_name: string, isChecked: boolean) {
  //   const emailFormArray = <FormArray>this.myForm.controls.p_names;
  //   console.log("Class1",emailFormArray.value);
  //   if (isChecked) {
  //     emailFormArray.push(new FormControl(p_name));
  //     console.log("emailFormArray",emailFormArray.value);
  //     this.value = emailFormArray.value;
  //   } else {
  //     let index = emailFormArray.controls.findIndex(x => x.value == p_name)
  //     emailFormArray.removeAt(index);
  //     console.log("emailFormArray",emailFormArray);
  //   }
 
  // }

  found(){
    //this.router.navigate[('/billing/Product')];
    this.router.navigate(['/billing/Product']);
  }

  viewhide(megha){
    console.log("megha",megha);
  }

 

 
  onClickSubmit(){
if(this.bill.c_id==undefined){
  console.log(this.myForm.value);
      this.billService.createCustomer(this.bill,this.myForm.value).subscribe((bill)=>{
        console.log(bill);
      },(error)=>{
        console.log(error);
      });
  }
   else{
     this.billService.updateCustomer(this.bill,this.myForm.value).subscribe((bill)=>{
       console.log(bill);
     },(error)=>{
      console.log(error);
     });
   }
  }


  newCustomer(){
    this.router.navigate(['/billing/customer-form']);
  }

  @ViewChild('infoModal') public infoModal: ModalDirective;


}


function minSelectedCheckboxes(min = 1) {
  const validator: ValidatorFn = (formArray: FormArray) => {
    const totalSelected = formArray.controls
      .map(control => control.value)
      .reduce((prev, next) => next ? prev + next : prev, 0);

    return totalSelected >= min ? null : { required: true };
  };

  return validator;
}
