import { Component, OnInit ,ViewChild} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {ModalDirective} from 'ngx-bootstrap/modal';
import { BillService } from '../../bill.service';
import { Bill } from '../../bill';
import { Router } from '@angular/router';
import { analyzeAndValidateNgModules } from '@angular/compiler';





@Component({
  selector: 'app-customer-bill',
  templateUrl: './customer-bill.component.html',
  styleUrls: ['./customer-bill.component.scss']
})
export class CustomerBillComponent implements OnInit {
  show:boolean=true;

  readonly APP_URL = "http://localhost:8082/ERP-Company/";
  myresponse1:any;
  private bill:Bill;
  myresponse: any;

  constructor(private _http: HttpClient,private billService:BillService,private router:Router ) { }

  ngOnInit() {
    
  }
  value : String;
  onClickSubmit(data){
     this.value = data["c_name"];
    console.log("%%%****"+this.value);
    this._http.post(this.APP_URL + 'bill/c_name', JSON.stringify(data))
    .subscribe(result => {
           console.log('inside postmehtod of sub.function', result);//only objects
          
           if(result)
           this.show=true;
          else
          this.show=false;
        })
        this._http.get(this.APP_URL +'bill/customer_data?value='+this.value).subscribe(
          result1=>{
            this.myresponse1=result1;
            let bill: Bill[];
            // let resSTR = JSON.stringify( this.myresponse1);
            // console.log("resSTR",resSTR);
            let jo = JSON.parse(JSON.stringify(this.myresponse1)); 
            console.log(jo);
            for(let i=0;i<jo.length;i++){
            console.log(jo[i]); 
            this.myresponse  = jo[i];
            console.log("myresponse",this.myresponse);
}
          },
          error=>{
            console.log("error Occured",error);
          }
        );
  }

  getCData(bill){
    this.billService.setter(bill);
    this.router.navigate(['/billing/customer-form']);
  }

  save1(){
    let bill = new Bill();
    this.billService.setter(bill);
    this.router.navigate(['/billing/customer-form']);
  }

  @ViewChild('infoModal') public infoModal: ModalDirective;


}
