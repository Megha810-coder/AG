import { Component, OnInit ,ViewChild} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BillService } from '../../bill.service';
import { Router } from '@angular/router';
import { Bill } from '../../bill';
import {ModalDirective} from 'ngx-bootstrap/modal';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.scss']
})
export class ProductFormComponent implements OnInit {

  readonly APP_URL = 'http://localhost:8082/ERP-Company/';

  private bill:Bill;
  bnamePattern = "^[a-zA-Z\s]+$";
  uomPattern = "^[a-zA-Z\s]+$";
  pnamePattern = "^[a-zA-Z\s]+$";
  rtPattern="^[0-9]*\.?[0-9]*$";
  hsnPattern="^[0-9]*$";
  quantityPattern="^[0-9]*$";
  minquantityPattern="^[0-9]*$";
  constructor(private billService:BillService,private router:Router,private http:HttpClient) { }

  ngOnInit() {
    this.bill = this.billService.getter();
  }

  onClickSubmit(){
    if(this.bill.p_id==undefined){
      console.log("in the function******************");
      this.billService.createProduct(this.bill).subscribe((bill)=>{
        console.log(bill);
      },(error)=>{
        console.log(error);
      });

  }
   else{
     this.billService.updateProduct(this.bill).subscribe((bill)=>{
       console.log(bill);
     },(error)=>{
      console.log(error);
     });
   }
  }

  @ViewChild('infoModal') public infoModal: ModalDirective;

}
