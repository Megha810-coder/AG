import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-customerreport',
  templateUrl: './customerreport.component.html',
  styleUrls: ['./customerreport.component.scss']
})
export class CustomerreportComponent implements OnInit {

  constructor(private router:Router,private _http:HttpClient,private modalService: NgbModal) { }

  readonly APP_URL = "http://localhost:8082/ERP-Company/";
  myresponse3:any;
  show:boolean=false;
  show1:boolean=true;
  value:any;
  value1:any;
  value2:any;
  date1:any;
  date2:any;
  i:number;

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
 // var value =JSON.stringify(data);
  this._http.post(this.APP_URL +'bill/custR',JSON.stringify(data)).subscribe(
    result1=>{
     // alert("done";
     this.show=true;
     this.show1=false;
      this.myresponse3 =result1;
      for(this.i=0;this.i<this.myresponse3.length;this.i++){
        this.value = this.myresponse3[this.i].c_name;
        this.value1  = this.myresponse3[this.i].c_gst;
        this.value2 = this.myresponse3[this.i].c_add;
      }
      //this.value = this.myresponse3["c_add"];
      //console.log(this.value);
      console.log('inside postmehtod of sub.function', result1);
  //    this.value1=result1;
     // console.log("this.value1",this.value1);
    },
    error=>{
      console.log("error Occured",error);
    }
   ) ;
      

}
}
