import { Component, OnInit } from '@angular/core';
import { BillService } from '../../bill.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Bill } from '../../bill';
import * as _ from 'lodash';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {

  readonly APP_URL = 'http://localhost:8082/ERP-Company/';
  myresponse:any;
  private bill:Bill[];
  i:number=0;
  data1=[];
  dataa:number=10;
  myresponse2:any;

  constructor(private billService:BillService,private router:Router,private http:HttpClient) { }

  ngOnInit() {
    this.http.get(this.APP_URL + 'bill/mng_product').subscribe(
      result => {
 
        console.log('hiii') ;
        this.myresponse = result ;
        console.log('this.myresponse', this.myresponse);
        for(this.i=0;this.i<this.myresponse.length;this.i++){
          var value = this.myresponse[this.i].packages;
          this.data1.push(value);
          console.log("data1:",this.data1);
        }
  //       this.myresponse2=_.merge(this.data1,this.myresponse);
  // console.log("this.myresponse2:",this.myresponse2);

      },
      error => {
        console.log('Error occured', error);
      }
    );
  }

  save(){
    let bill =new Bill();
    this.billService.setter(bill);
    this.router.navigate(['/billing/Product-form']);
  }

  viewProduct(bill){
    this.billService.setter(bill);
    this.router.navigate(['/billing/Product-view']);
    
  }

  updateProduct(bill){
    this.billService.setter(bill);
    this.router.navigate(['/billing/Product-form']);
  }

  deleteProduct(id){
    this.http.get(this.APP_URL + 'bill/delete_product?p_id='+id).subscribe(
      result => {
        alert("delete successfully!!!!");
        this.myresponse = result ;
      },
      error => {
        console.log('Error occured', error);
      }
    );
  }

  public selectedName:any;
  
  public highlightRow(product) {
    this.selectedName = product.packages ;
    // if(this.selectedName < 10){
    //   this.dataa = product.packages;
    // }
  }

}
