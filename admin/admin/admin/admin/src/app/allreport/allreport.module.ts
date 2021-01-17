import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { allreportRoutingModule } from './allreport-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AllcustomerComponent} from './allcustomer/allcustomer.component';
import { CustomerComponent } from './customer/customer.component';
import { ProductreportComponent } from './productreport/productreport.component';

@NgModule({
  declarations: [AllcustomerComponent, CustomerComponent, ProductreportComponent],
  imports: [
    CommonModule,allreportRoutingModule,FormsModule,HttpModule
  ]
})
export class AllreportModule { }
