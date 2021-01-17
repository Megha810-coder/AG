import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-productreport',
  templateUrl: './productreport.component.html',
  styleUrls: ['./productreport.component.scss']
})
export class ProductreportComponent implements OnInit {


  constructor(private router:Router,private _http:HttpClient,private modalService: NgbModal) { }
  show:boolean=false;
  show1:boolean=true;
  date1:any;
  date2:any;
  value3:number=0;
  i:number;
  value4:number=0;
  value5:number=0;
  arr=[];
  outputArray = []; 
  m:number=0;
  n:number=0;
  k:number=0;
  resultarr=[0];
  resultarr2=[];
  resultarr1:number=0;
  myresponse4:any;
  
  readonly APP_URL = "http://localhost:8082/ERP-Company/";
  myresponse3:any;
  ngOnInit() {
    
  }

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

  onClickSubmit(data){
    this.date1 = data["from"];
    console.log(this.date1);
    this.date2 = data["to"];
    console.log(this.date2);
    this._http.post(this.APP_URL +'bill/mng_product_report',JSON.stringify(data)).subscribe(
      result1=>{
        this.myresponse3 =result1;
        console.log(" this.myresponse3", this.myresponse3);
        if(this.myresponse3.length==0){
          alert("No Result Found.");
        }
        this.show=true;
        this.show1=false;
      
        // for(this.i=0;this.i<this.myresponse3.length;this.i++){
        //   this.value3 = +this.value3 + +this.myresponse3[this.i].quantity;
        //   //console.log(" this.value3", this.value3);
        //   var value1 = this.myresponse3[this.i].name;
        //   this.arr.push(value1);
        //   console.log(" this.arr", this.arr);
        //   var count = 0; 
        //   var start = false; 
            
        //   for (let j = 0; j <  this.arr.length; j++) { 
        //       for (let k = 0; k < this.outputArray.length; k++) { 
        //           if ( this.arr[j] == this.outputArray[k] ) { 
        //               start = true; 
        //           } 
        //       } 
        //       count++; 
        //       if (count == 1 && start == false) { 
        //         this.outputArray.push(this.arr[j]); 
        //       } 
        //       start = false; 
        //       count = 0; 
        //   } 
        //   console.log("this.outputArray",this.outputArray);
        // }
        this._http.post(this.APP_URL +'bill/mng_product_report1',JSON.stringify(data)).subscribe(
          result1=>{
            this.myresponse4 =result1;
            console.log(" this.myresponse4", this.myresponse4);
            // if(this.myresponse3.length==0){
            //   alert("No Result Found.");
            // }
          },
          error=>{
            console.log("error Occured",error);
          }
         ) ;
      },
      error=>{
        console.log("error Occured",error);
      }
     ) ;
    
        
        
  
  }

  back(){
    this.show=false;
    this.show1=true;
  }

  
print(){
  window.print();
}
  

}
