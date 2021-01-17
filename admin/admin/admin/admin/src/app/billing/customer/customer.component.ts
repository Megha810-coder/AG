import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Bill } from '../../bill';
import { BillService } from '../../bill.service';


@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent implements OnInit {
  readonly APP_URL =  "http://localhost:8082/ERP-Company/";
  myresponse:any;


  constructor(private billService:BillService,private router:Router,private http:HttpClient) { }

  ngOnInit() {
    this.http.get(this.APP_URL +'bill/mng_customer').subscribe(
      result=>{
        this.myresponse=result;
        console.log("myresponse",this.myresponse);
      },
      error=>{
        console.log("error Occured",error);
      }
    );

  }


  save(){
    let bill= new Bill();
    this.billService.setter(bill);
    this.router.navigate(['/billing/customer-form']);
  }

  viewCustomer(bill){
    this.billService.setter(bill);
    this.router.navigate(['/billing/customer-view']);
  }

  updateCustomer(bill){
    this.billService.setter(bill);
    this.router.navigate(['/billing/customer-form']);
  }

  deleteCustomer(id){
    this.http.get(this.APP_URL + 'bill/delete_customer?c_id='+id).subscribe(
      result => {
        alert("delete successfully!!!!");
        this.myresponse = result ;
      },
      error => {
        console.log('Error occured', error);
      }
    );
  }

}
