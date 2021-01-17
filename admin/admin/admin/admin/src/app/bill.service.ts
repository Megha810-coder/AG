import { Injectable } from '@angular/core';
import { Headers, Http, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';
import { Bill }  from './bill';
import * as _ from 'lodash';

@Injectable({
  providedIn: 'root'
})
export class BillService {

  private baseUrl:String="http://localhost:8082/ERP-Company/";
  private headers = new Headers({'Content-Type':'application/json; charset=utf8'});
  private options = new RequestOptions({headers:this.headers});
  private bill :Bill;

  constructor(private _http:Http) { }

  createUser(bill:Bill){
    return this._http.post(this.baseUrl+'',JSON.stringify(bill)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  updateUser(bill:Bill){
    return this._http.post(this.baseUrl+'',JSON.stringify(bill)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  createProduct(bill:Bill){
    return this._http.post(this.baseUrl+'bill/save_product',JSON.stringify(bill)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  updateProduct(bill:Bill){
    return this._http.post(this.baseUrl+'bill/update_product',JSON.stringify(bill)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

 
  createCustomer(bill:Bill,value){

    //  let jo = JSON.parse(JSON.stringify(value)); 
      console.log(value);
    
      
     var data = _.merge(bill,value);
  return this._http.post(this.baseUrl+'bill/product_details',JSON.stringify(data)).map((response:Response)=>response.json())
.catch(this.errorHandler);
  }

  updateCustomer(bill:Bill,value){
    var data = _.merge(bill,value);
    return this._http.post(this.baseUrl+'bill/product_details',JSON.stringify(data)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  createVendor(bill:Bill){
    return this._http.post(this.baseUrl+'bill/save_vendor',JSON.stringify(bill)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  
  updateVendors(bill:Bill){
    return this._http.post(this.baseUrl+'bill/update_vendor',JSON.stringify(bill)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR");
  }

  setter(bill:Bill){
    this.bill=bill;
  }


  getter(){
    return this.bill;
  }
}
