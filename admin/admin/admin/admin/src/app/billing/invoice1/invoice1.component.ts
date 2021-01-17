import { Component, OnInit,ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {ModalDirective} from 'ngx-bootstrap/modal';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import * as _ from 'lodash';
import { Bill } from '../../bill';
import { BillService } from '../../bill.service';




@Component({
  selector: 'app-invoice1',
  templateUrl: './invoice1.component.html',
  styleUrls: ['./invoice1.component.scss']
})
export class Invoice1Component implements OnInit {

  constructor(private fb: FormBuilder,private modalService: NgbModal,private _http:HttpClient,private router:Router,private billService:BillService) { }
  value:any;
  show:any;
  myresponse1:any;
  myresponse:any;
  myresponse3:any;
  myresponse4:any;
  myForm: FormGroup;
  private bill:Bill;
  value1:any;
  value11:any;
  show12:boolean=false;
  count:number=0;
  amount:any;
  num:number=1;
  myresponse6:any;
 data=[];
 data1=[];
 data2=[];
 ans:any;
 ans1:any;
 ans2:any;
 ans3:any;
 show11:boolean=true;
 myresponse9:any;
 a:any;
b:any;
t:number=0;
valuee:number=0;
i:number;
total1:any;
total2:any;
total3:number=0;
total4:any;
total5:any;
rf:number=0;
rf1:number=0;
rf2:number=0;
rf3:number=0;
rf4:number=0;
quantity:any;
z:number=0;
y:number=0;

cntPattern = "^((\\+91-?)|0)?[0-9]{10}$"; 
  emailPattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$";
  gstPattern="^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$";
  namePattern = "^[a-zA-Z\s]+$";
  rtPattern="^[0-9]*\.?[0-9]*$";



  
  readonly APP_URL = "http://localhost:8082/ERP-Company/";

  ngOnInit() {
    this._http.get(this.APP_URL +'bill/quantity').subscribe(
      result1=>{
        this.quantity = result1;
        console.log("this.quantity", this.quantity);
      },
      error=>{
        console.log("error Occured",error);
      }
    );

    this._http.get(this.APP_URL +'bill/bill').subscribe(
      result1=>{
        this.value1=+result1+1;
        console.log("this.value1",this.value1);
      },
      error=>{
        console.log("error Occured",error);
      }
    );
   
      let bill =new Bill();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
      this.billService.setter(bill);
    this.bill = this.billService.getter();
    
    this.createform(); 
   

  }

  search(data){
    console.log(data);
    this.value = data["name"];
    // this.value11=data["c_id"];
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
            // let bill: Bill[];
            // let resSTR = JSON.stringify( this.myresponse1);
            // console.log("resSTR",resSTR);
            console.log("this****",this.myresponse1);
            let jo = JSON.parse(JSON.stringify(this.myresponse1)); 
            console.log(jo);
            for(let i=0;i<jo.length;i++){
            console.log(jo[i]); 
            this.myresponse  = jo[i];
            console.log("myresponse****",this.myresponse);
}
          },
          error=>{
            console.log("error Occured",error);
          }
        );
        this._http.get(this.APP_URL +'bill/save?value='+this.value11).subscribe(
          result1=>{
            this.myresponse3=result1;
            console.log("this.myresponse3",this.myresponse3);
          
           
            let jo = JSON.parse(JSON.stringify(this.myresponse3)); 
            console.log(jo);
            for(let i=0;i<jo.length;i++){
            console.log(jo[i]); 
            this.myresponse4  = jo[i];
            console.log("this.myresponse4",this.myresponse4);
}
          },
          error=>{
            console.log("error Occured",error);
          }
        );
  }
    
  nam:string;

  onchange(nam){
    console.log("name:",nam);
    this._http.get(this.APP_URL +'bill/customer_data?value='+nam).subscribe(
      result1=>{
        console.log("result1=",result1);
        // if(nam==null){
        //   alert("Please enter Customer name");
        // }
if(result1!=null)  
{ 
  this.myresponse1=result1;
  // console.log("this.myresponse1",this.myresponse1);
  // console.log("this****",this.myresponse1);
  let jo = JSON.parse(JSON.stringify(this.myresponse1)); 
  //console.log(jo);
  for(let i=0;i<jo.length;i++){
  console.log(jo[i]); 
  this.bill  = jo[i];
  this.value11=this.bill.c_id
  this._http.get(this.APP_URL +'bill/save?value='+this.value11).subscribe(
    result2=>{
      this.myresponse3=result2;
      console.log("this.myresponse3",this.myresponse3);
      this.myresponse9 = _.merge(this.myresponse3,this.data1);
      console.log("this.data1",this.data1);
      console.log("this.myresponse9",this.myresponse9);
      this.count=this.myresponse3.length;
      console.log("this.myresponse3",this.myresponse3.length);
    },
    error=>{
      console.log("error Occured",error);
    }
  );
  this.show12=true;
//   console.log("myresponse****",this.bill);
//  this.billService.setter(this.bill);
var value = _.merge(this.bill,this.show12);
this.billService.setter(value);
 this.router.navigate(['/billing/invoice1']);
}
   alert("Customer found");
}
else{
let bill =new Bill();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
console.log(bill);
this.show12=true;
var value = _.merge(bill,this.show12);
this.billService.setter(value);
this.router.navigate(['/billing/invoice1']);
alert("Customer not found");
//this.router.navigate(['/ehs_module/hira-form']);
}
      },
      error=>{
        console.log("error Occured",error);
      }
    );

  }

  save1(){
    // let bill = new Bill();
    // this.billService.setter(bill);
    this.router.navigate(['/billing/customer-form1']);
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

  createform()    
  {    
    let arr=[];
    this._http.get(this.APP_URL +'bill/product').subscribe(
      result=>{
        this.myresponse1=result;
        console.log("myresponse1&***",this.myresponse1);
        for(let i=0;i<this.myresponse1.length;i++)    
        {       
          arr.push(this.BuildFormDynamic(this.myresponse1[i]))    
        }    
          this.myForm =  this.fb.group({    
            ClassDetails:this.fb.array(arr)  
          })  
      },
      error=>{
        console.log("error Occured",error);
      }
    );
  }

  BuildFormDynamic(product):FormGroup{    
    return this.fb.group({ 
          Class:[product.p_name], 
          rate:[''],   
     })    
   }
  

   onClickSubmit(data){
    var value = _.merge(data,this.myForm.value);
    this._http.post(this.APP_URL+'bill/save_contract', JSON.stringify(value))
     .subscribe(res => {
            console.log('inside postmehtod of sub.function', res);//only objects
         })
      }

      onClickSubmit1(data){
        var value = _.merge(data,this.myForm.value);
        this._http.post(this.APP_URL+'bill/save_contract1', JSON.stringify(value))
         .subscribe(res => {
                console.log('inside postmehtod of sub.function', res);//only objects
             })
          }

      show1(bill){
         this.billService.setter(bill);
       this.router.navigate(['/billing/invoice1']);

      }

      savePage(myresponse1)
      {
        this.router.navigate(['/billing/invoice1']);
        console.log("****");
        console.log(myresponse1);
      }
      
      qty:number;
      rate:number;

      onchange1(qty,rate){
        console.log(qty);
        console.log(rate);
        this.amount =qty*rate;
        console.log("this.amount",this.amount);
      }

      total:any;
      num1: number = 2;
      num2: number = 3;
      sum: number = 0;

      // onclick1(amt){
      //   //  this.sum = this.num1 + this.num2;
      //   //  console.log("this.sum",this.sum);
      //   console.log("amt",amt);
      //   this.total= +this.total + +amt;
      //   console.log(" this.total", this.total);
      //   // this.total=this.total+amt;
      // }
      
    

      onclick12(qty,rate){
        console.log("qty:",qty);
        console.log("rate:",rate);
       let qty1 = qty*rate;
       console.log(" this.qty1",qty1);
        this.t= +this.t + +qty1;
        console.log(" this.t", this.t);
      }

      values = '';
      onChange(amt) {
        this.values = amt;
        console.log(this.values);
     };
     

      onSelect(selectedItem: any,qty,rate) 
	{
 
        console.log("qty:",qty);
        console.log("rate:",rate);
   console.log("Selected item Id: ", selectedItem.p_HSN); 
   console.log("Selected item Id: ", selectedItem.pro_name); 
   console.log(" this.t", this.t);
   this.total = this.t.toFixed(2);
  // this.show11=false;
   var upload={"quantity":qty, "rate":rate,"HSN":selectedItem.p_HSN,"name":selectedItem.pro_name,"total":this.total}
    let copy =JSON.parse(JSON.stringify(upload))
    console.log("copy",copy);
    this.data.push(copy);
    console.log("this.data", this.data);
      
  }
  
  
  //console.log("data",data);
      getClient(pro){
        console.log(pro);
     }

     search11(data){
       console.log(data);
     }

   
    selectChangeHandler (event: any) {
      //update the ui
      this.myresponse6 = event.target.value;
      console.log("this.myresponse6:",this.myresponse6);
    }

    onclick12111(gst,gst1,qty,rate){
      console.log("this.gst:",gst);
      console.log("this.gst1:",gst1);
      console.log("qty:",qty);
      console.log("rate:",rate);
      console.log("-------------------------------------------------");
      if(gst==1){
        this.ans = qty*rate;
        this.ans1 = gst1/100;
        this.a =  this.ans*this.ans1;
        console.log(" this.a:", this.a);
        this.ans2=this.a.toFixed(2);
        this.b = this.ans- this.a;
        console.log("this.b:",this.b);
        this.ans3=this.b.toFixed(2);
        var upload1={"ans2":this.ans2, "ans3":this.ans3,"gstType":gst,"gst":gst1}
        let copy1 =JSON.parse(JSON.stringify(upload1))
        console.log("copy",copy1);
        this.data1.push(copy1);
     
       
      let sum = 0;
      let sum2 = 0;
    //   for (var i = 0; i < this.data1.length; i++) {
    //     sum += +this.data1[i].ans2;
    //     sum2 += +this.data1[i].ans3;
    // }
    // this.total1= sum;
    // console.log("this.total1",this.total1);
    // this.total2 =sum2; 
    // console.log("this.total2",this.total2);
      }

      if(gst==2){
        this.ans = qty*rate;
        this.ans1 = gst1/100;
        this.a =  this.ans*this.ans1;
        console.log(" this.a:", this.a);
        this.ans2=this.a.toFixed(2);
        this.b = this.ans+this.a;
        console.log("this.b:",this.b);
        this.ans3=this.b.toFixed(2);
        var upload3={"ans2":this.ans2, "ans3":this.ans3,"gstType":gst,"gst":gst1}
        let copy1 =JSON.parse(JSON.stringify(upload3))
        console.log("copy",copy1);
        this.data1.push(copy1);
        console.log("this.data1", this.data1);
        let sum = 0;
        let sum2= 0;
        // for (var i = 0; i < this.data1.length; i++) {
        //  sum += +this.data1[i].ans2;
        //  sum2 += +this.data1[i].ans3;
        // }
        // this.total4= sum;
        // this.total3=sum2;
        // console.log(" this.total4", this.total4);
        //   console.log("this.total3",this.total3);
      }

      if(gst==0){
        this.ans3 = qty*rate;
        console.log("this.ans3:",this.ans3);
        var upload2={"ans3":this.ans3,"ans2":0}
        let copy1 =JSON.parse(JSON.stringify(upload2))
        console.log("copy",copy1);
        this.data1.push(copy1);
        console.log("this.data1", this.data1);
      }

      // this.total = this.total3+this.total2;
      // console.log("this.total",this.total);
      // this.total5 = this.total1 +this.total4;
      // console.log("this.total5",this.total5);
      // this.total6 = this.total - this.total5;
      // console.log("this.total6",this.total6);
    }

    changeValue(){
      this.show11=false;
      this.myresponse9 = _.merge(this.myresponse3,this.data1);
      console.log("this.myresponse9",this.myresponse9);
      let sum = 0;
      let sum2= 0;
      for (var i = 0; i < this.data1.length; i++) {
         sum += +this.data1[i].ans2;
          sum2 += +this.data1[i].ans3;
        }
        // this.total = sum;
        // console.log("this.total",this.total);
        // this.total1 = sum2;
        // this.total4 = this.total1/2;
        // console.log("this.total1",this.total1);
        // this.total2 = this.total1 - this.total;
        // console.log("this.total2",this.total2);
        this.rf=sum;
        this.total = this.rf.toFixed(2);
        console.log("this.total",this.total);
        this.rf1 = sum2;
        this.total1 = this.rf1.toFixed(2);
        this.rf4 = this.total/2
        this.total4 = this.rf4.toFixed(2);
        console.log("this.total1",this.total1);
        this.rf2 = this.total1 - this.total;
        this.total2 = this.rf2.toFixed(2);
        console.log("this.total2",this.total2);
        this.total5=0;

    }

    onClickSubmit12(data){
      console.log("data:",data);
      var mergerdata = _.merge(data,this.data);
      console.log("mergerdata:",mergerdata);
      var mergedata2 =_.merge(mergerdata,this.data1);
      console.log("mergedata2:",mergedata2);
      this._http.post(this.APP_URL+'bill/save_bill', JSON.stringify(mergedata2))
      .subscribe(res => {
             console.log('inside postmehtod of sub.function', res);//only objects
          })
    }

    print() {
      window.print();
      }

      stockDispaly(prod,qty){
        console.log("prod1===========",prod);
        console.log("qty1==========",qty);
        for(this.z=0;this.z<this.quantity.length;this.z++){
          if(this.quantity[this.z].p_name==prod){
            var name =this.quantity[this.z].p_name;
            if(this.quantity[this.z].packages<qty){
              this.y= this.quantity[this.z].packages;
              alert("Insufficient Stock");
              alert("The stock is "+this.y+" of "+name);
            }
          }
        }
      }



  @ViewChild('infoModal') public infoModal: ModalDirective;

}
