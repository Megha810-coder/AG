import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-productreport',
  templateUrl: './productreport.component.html',
  styleUrls: ['./productreport.component.scss']
})
export class ProductreportComponent implements OnInit {

  constructor(private router:Router,private _http:HttpClient) { }

  readonly APP_URL = "http://localhost:8082/ERP-Company/";
  myresponse3:any;

  ngOnInit() {
    this._http.get(this.APP_URL +'bill/mng_product_report').subscribe(
      result2=>{
        this.myresponse3=result2;
        console.log("this.myresponse3",this.myresponse3);
      },
      error=>{
        console.log("error Occured",error);
      }
    );
  }

}
