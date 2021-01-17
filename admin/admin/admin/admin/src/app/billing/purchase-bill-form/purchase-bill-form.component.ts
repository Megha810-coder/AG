import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-purchase-bill-form',
  templateUrl: './purchase-bill-form.component.html',
  styleUrls: ['./purchase-bill-form.component.scss']
})
export class PurchaseBillFormComponent implements OnInit {

  readonly APP_URL="http://localhost:8082/ERP-Company/";
  myresponse:any;

  constructor(private http:HttpClient) { }

  ngOnInit() {
    this.http.get(this.APP_URL +'bill/customer_list').subscribe(
      result=>{
        this.myresponse=result;
        console.log("myresponse",this.myresponse);
      },
      error=>{
        console.log("error Occured",error);
      }
    );

  }

  date12(data){
    console.log("data",data);
  }

}
