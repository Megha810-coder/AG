import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
//import { ProductComponent } from './product/product.component';
import { AllcustomerComponent} from './allcustomer/allcustomer.component';
import { CustomerComponent } from './customer/customer.component';
import { ProductreportComponent } from './productreport/productreport.component';

export const routes: Routes = [
    {
    path: '',
    data: {
      title: 'allreport'
    },
    children: [
     {
         path:'',
         redirectTo:'allreport'
     },

    {
             path: 'AllCustomer',
             component: AllcustomerComponent,
             data: {
               title: 'AllCustomer'
             }
          },
          {
            path: 'Customer',
            component: CustomerComponent,
            data: {
              title: 'Customer'
            }
         },
         {
          path: 'Product',
          component: ProductreportComponent,
          data: {
            title: 'Product'
          }
       },
   
    ]
  }

];
@NgModule({
    imports: [ RouterModule.forChild(routes) ],
    exports: [ RouterModule ]
  })
export class allreportRoutingModule {}
  