import { Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent implements OnInit {

  constructor(private router:Router,private _http:HttpClient,private modalService: NgbModal) { }

  readonly APP_URL = "http://localhost:8082/ERP-Company/";
  myresponse3:any;
  show:boolean=false;
  show1:boolean=true;
  value:any;
  value1:any;
  value2:any;
  value3:number=0;
  value4:number=0;
  value5:number=0;
  value6:number=0;
  value7:number=0;
  value8:number=0;
  date1:any;
  date2:any;
  total:any;
  i:number;
  j:number;

  closeResult: string;
  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

  ngOnInit() {


}

onClickSubmit(data){
  console.log(data);
  this.date1 = data["from"];
  console.log(this.date1);
  this.date2 = data["to"];
  console.log(this.date2);
  this._http.post(this.APP_URL +'bill/allcustR',JSON.stringify(data)).subscribe(
    result1=>{
     this.show=true;
     this.show1=false;
      this.myresponse3 =result1;
      if(this.myresponse3.length==0){
        alert("No Result Found.");
      }
      this.total = this.myresponse3.length;
      console.log("this.total",this.total);
      for(this.i=0;this.i<this.myresponse3.length;this.i++){
        this.value3 = +this.value3 + +this.myresponse3[this.i].grossamt;
        this.value4 = +this.value4 + +this.myresponse3[this.i].cgst;
        this.value5 = +this.value5 + +this.myresponse3[this.i].sgst;
        this.value6 = +this.value6 + +this.myresponse3[this.i].igst;
        this.value7 = +this.value7 + +this.myresponse3[this.i].gstamt1;
        this.value8 = +this.value8 + +this.myresponse3[this.i].netamt;
        console.log(" this.value3", this.value3);
        console.log(" this.value3", this.value4);
        console.log(" this.value3", this.value5);
        console.log(" this.value3", this.value6);
        console.log(" this.value3", this.value7);
        console.log(" this.value3", this.value8);
      }
      console.log('inside postmehtod of sub.function', result1);
    },
    error=>{
      console.log("error Occured",error);
    }
   ) ;
      

}

print(){
  window.print();
}

back(){
  this.show=false;
  this.show1=true;
}


}
