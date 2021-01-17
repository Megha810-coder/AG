import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder } from '@angular/forms';
import { BillService } from '../../bill.service';
import { Bill } from '../../bill';

@Component({
  selector: 'app-customer-form1',
  templateUrl: './customer-form1.component.html',
  styleUrls: ['./customer-form1.component.scss']
})
export class CustomerForm1Component implements OnInit {

  myresponse1:any;
  myForm: FormGroup;
  readonly APP_URL = "http://localhost:8082/ERP-Company/";
  private bill:Bill;
 

  constructor(private fb: FormBuilder,private http:HttpClient,private billService:BillService) { }

  ngOnInit() {
    this.createform();    
    this.myForm = this.fb.group({
      p_names: this.fb.array([]),
    });
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
  

}
