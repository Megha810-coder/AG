import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {billingRoutingModule}  from './billing-routing.module';
import { ProductComponent } from './product/product.component';
import { ProductFormComponent } from './product-form/product-form.component';
import { ProductViewComponent } from './product-view/product-view.component';
import { PurchaseBillComponent } from './purchase-bill/purchase-bill.component';
import { PurchaseBillFormComponent } from './purchase-bill-form/purchase-bill-form.component';
import { CustomerComponent } from './customer/customer.component';
import { CustomerFormComponent } from './customer-form/customer-form.component';
import { CustomerViewComponent } from './customer-view/customer-view.component';
import { VendorsComponent } from './vendors/vendors.component';
import { VendorsFormComponent } from './vendors-form/vendors-form.component';
import { VendorsViewComponent } from './vendors-view/vendors-view.component';
import { CustomerBillComponent } from './customer-bill/customer-bill.component';
import { CustomerBillFormComponent } from './customer-bill-form/customer-bill-form.component';
import { ModalModule } from 'ngx-bootstrap/modal';
import { ReactiveFormsModule } from '@angular/forms';
import { QuotationComponent } from './quotation/quotation.component';
import { InvoiceComponent } from './invoice/invoice.component';
import { CustomerForm1Component } from './customer-form1/customer-form1.component';
import { Invoice1Component } from './invoice1/invoice1.component';
import { ProductreportComponent } from './productreport/productreport.component';
import { CustomerreportComponent } from './customerreport/customerreport.component';

@NgModule({
  declarations: [ProductComponent, ProductFormComponent, ProductViewComponent, PurchaseBillComponent, PurchaseBillFormComponent, CustomerComponent, CustomerFormComponent, CustomerViewComponent, VendorsComponent, VendorsFormComponent, VendorsViewComponent, CustomerBillComponent, CustomerBillFormComponent, QuotationComponent, InvoiceComponent, CustomerForm1Component, Invoice1Component, ProductreportComponent, CustomerreportComponent],
  imports: [
    CommonModule,billingRoutingModule,FormsModule,HttpModule, ModalModule.forRoot(),ReactiveFormsModule
  ]
})
export class BillingModule { }
