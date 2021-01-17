import { Component, OnInit,ViewChild } from '@angular/core';
import { Bill } from '../../bill';
import { BillService } from '../../bill.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import {ModalDirective} from 'ngx-bootstrap/modal';

@Component({
  selector: 'app-vendors-form',
  templateUrl: './vendors-form.component.html',
  styleUrls: ['./vendors-form.component.scss']
})
export class VendorsFormComponent implements OnInit {

  readonly APP_URL = "http://localhost:8082/ERP-Company/";

  private bill:Bill;
  myresponse:any;
  namePattern = "^[a-zA-Z\s]+$";
  cntPattern = "^((\\+91-?)|0)?[0-9]{10}$"; 
  gstPattern="^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$";
  emailPattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$";


  constructor(private billService:BillService,private router:Router,private http:HttpClient) { }

  ngOnInit() {
    this.bill = this.billService.getter();
  }

  onClickSubmit(){
    if(this.bill.v_id==undefined){
      console.log("in the function******************");
      this.billService.createVendor(this.bill).subscribe((bill)=>{
        console.log(bill);
      },(error)=>{
        console.log(error);
      });

  }
   else{
     this.billService.updateVendors(this.bill).subscribe((bill)=>{
       console.log(bill);
     },(error)=>{
      console.log(error);
     });
   }
  }

  onchange(nam){
    console.log("name:",nam);
    this.http.get(this.APP_URL +'bill/vendor_data?value='+nam).subscribe(
      result1=>{
       this.myresponse =result1;
       },
      error=>{
        console.log("error Occured",error);
       }
    );

  }

  @ViewChild('infoModal') public infoModal: ModalDirective;

}
