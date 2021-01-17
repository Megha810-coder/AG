import { DecimalPipe } from '@angular/common';

export class Bill {

    //Product
    min_quantity:Number;
    p_active: Number;
    p_brand:String; 
    p_code: String;
    p_id: Number;
    p_name: String;
    packages:Number; 
    rate: Number;
    size: String;
    uom: String;

    //customer
    address:String; 
    c_id:Number; 
    c_name:String; 
    city:String; 
    contact_no:String; 
    email_id:String; 
    gst_no:String; 
    note_of_add:String; 
    pro:Number;
    // pro2:Number;
    // pro3:Number;
    // pro4:Number;

    // vendors
    v_id: Number;
    v_name:String;
    conatct_no:String;
    Gst_no:String;
   // city:String;
  // email_id:String;
  website:String;
  cgst:number;
  sgst:number;
  igst:number;
  value1:String;

}
