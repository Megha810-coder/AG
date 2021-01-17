import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { BillService } from '../../bill.service';
import { Bill } from '../../bill';

@Component({
  selector: 'app-vendors',
  templateUrl: './vendors.component.html',
  styleUrls: ['./vendors.component.scss']
})
export class VendorsComponent implements OnInit {
  private bill:Bill;
myresponse:any;
  readonly APP_URL = "http://localhost:8082/ERP-Company/";

  constructor(private http:HttpClient,private router:Router,private billService:BillService) { }

  ngOnInit() {
    this.http.get(this.APP_URL+'bill/mng_vendor').subscribe(
      result=>{
        this.myresponse=result;
        console.log("myresponse",this.myresponse);
      },
      error=>{
        console.log("error Occured");
      }
    );
  }

  save(){
    let bill = new Bill();
    this.billService.setter(bill);
    this.router.navigate(['/billing/vendors-form']);
  }

  viewVendors(bill){
    this.billService.setter(bill);
    this.router.navigate(['/billing/vendors-view']);
  }

  updateVendors(bill){
    this.billService.setter(bill);
    this.router.navigate(['/billing/vendors-form']);
  }
  deleteVendors(id){
    this.http.get(this.APP_URL + 'bill/delete_vendor?v_id='+id).subscribe(
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
