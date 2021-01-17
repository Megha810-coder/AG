import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';
import * as _ from 'lodash';

@Component({
  selector: 'app-quotation',
  templateUrl: './quotation.component.html',
  styleUrls: ['./quotation.component.scss']
})
export class QuotationComponent implements OnInit {

  readonly APP_URL="http://localhost:8082/ERP-Company/";
  myresponse:any;
  myresponse1:any;
  myForm: FormGroup;
  cntPattern = "^((\\+91-?)|0)?[0-9]{10}$"; 
  emailPattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$";
  gstPattern="^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$";
  namePattern = "^[a-zA-Z\s]+$";
  rtPattern="^[0-9]*\.?[0-9]*$";

  
  
  

  constructor(private fb: FormBuilder,private modalService: NgbModal,private router:Router,private http:HttpClient) { }

  closeResult: string;
  save(){
this.router.navigate(['/billing/customer-form1']);
  }
  ngOnInit() {
    // this.http.get(this.APP_URL +'bill/product').subscribe(
    //   result=>{
    //     this.myresponse=result;
    //     console.log("myresponse",this.myresponse);
    //   },
    //   error=>{
    //     console.log("error Occured",error);
    //   }
    // );
    this.createform();  
    // this.myForm = this.fb.group({
    //   p_names: this.fb.array([]),
    //   //size:([''])
    // });  
  }

  SaveData()    
  {    
    console.log(this.myForm.value);  
  }  

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
}


BuildFormDynamic(product):FormGroup{    
  return this.fb.group({ 
    
        Class:[product.p_name], 
      
        rate:[''],   
   })    
 }

  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

  onClickSubmit(data){
    var value = _.merge(data,this.myForm.value);
    this.http.post(this.APP_URL+'bill/save_contract', JSON.stringify(value))
     .subscribe(res => {
            console.log('inside postmehtod of sub.function', res);//only objects
         })
      }

    


}
