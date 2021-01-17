import { Component, OnInit,ViewChild } from '@angular/core';
import {ModalDirective} from 'ngx-bootstrap/modal';
import { Http } from '@angular/http';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.scss']
})
export class InvoiceComponent implements OnInit {

  readonly APP_URL = "http://localhost:8082/ERP-Company/";

  constructor(private http:HttpClient) { }

  ngOnInit() {
  }

  onClickSubmit(data){
    this.http.post(this.APP_URL +'bill/save_contract', JSON.stringify(data))
    .subscribe(res => {
           console.log('inside postmehtod of sub.function', res);//only objects
        })
    
  }

  @ViewChild('infoModal') public infoModal: ModalDirective;

}
