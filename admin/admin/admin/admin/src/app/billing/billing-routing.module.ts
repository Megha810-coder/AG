import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
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
import { QuotationComponent } from './quotation/quotation.component';
import { InvoiceComponent } from './invoice/invoice.component';
import { CustomerForm1Component } from './customer-form1/customer-form1.component';
import { Invoice1Component } from './invoice1/invoice1.component';
import { ProductreportComponent } from './productreport/productreport.component';
import { CustomerreportComponent } from './customerreport/customerreport.component';

export const routes: Routes = [
    {
    path: '',
    data: {
      title: 'billing'
    },
    children: [
     {
         path:'',
         redirectTo:'billing'
     },
      {
        path: 'Product',
        component: ProductComponent,
        data: {
          title: 'Product'
        }
      },
      {
        path: 'Product-form',
        component: ProductFormComponent,
        data: {
          title: 'Product-form'
        }
      },
      {
        path: 'Product-view',
        component: ProductViewComponent,
        data: {
          title: 'Product-view'
        }
      },
      {
        path: 'Purchasebill',
        component: PurchaseBillComponent,
        data: {
          title: 'Purchasebill'
        }
      },
      {
        path: 'Purchasebill-form',
        component: PurchaseBillFormComponent,
        data: {
          title: 'Purchasebill-form'
        }
      },
      {
        path: 'customer',
        component: CustomerComponent,
        data: {
          title: 'customer'
        }
      },
      {
        path: 'customer-form',
        component: CustomerFormComponent,
        data: {
          title: 'customer-form'
        }
      },
      {
        path: 'customer-view',
        component: CustomerViewComponent,
        data: {
          title: 'customer-view'
        }
      },
      {
        path: 'vendors',
        component: VendorsComponent,
        data: {
          title: 'vendors'
        }
      },
      {
        path: 'vendors-form',
        component: VendorsFormComponent,
        data: {
          title: 'vendors-form'
        }
      },
      {
        path: 'vendors-view',
        component: VendorsViewComponent,
        data: {
          title: 'vendors-view'
        }
      },
      {
        path: 'customer-bill',
        component: CustomerBillComponent,
        data: {
          title: 'customer-bill'
        }
      },
      {
        path: 'customer-bill-form',
        component: CustomerBillFormComponent,
        data: {
          title: 'customer-bill-form'
        }
      },
      {
        path: 'quotation',
        component: QuotationComponent,
        data: {
          title: 'quotation'
        }
      },
      {
        path: 'invoice',
        component: InvoiceComponent,
        data: {
          title: 'invoice'
        }
      },
      {
        path: 'customer-form1',
        component: CustomerForm1Component,
        data: {
          title: 'customer-form1'
        }
      },
      {
        path: 'invoice1',
        component: Invoice1Component,
        data: {
          title: 'invoice1'
        }
      },
      // {
      //   path: 'report',
      //   component: ReportComponent,
      //   data: {
      //     title: 'report'
      //   }
      // },
      {
        path: 'productreport',
        component: ProductreportComponent,
        data: {
          title: 'productreport'
        }
      },
      {
        path: 'customerreport',
        component: CustomerreportComponent,
        data: {
          title: 'customerreport'
        }
      },
    
    ]
  }

];
@NgModule({
    imports: [ RouterModule.forChild(routes) ],
    exports: [ RouterModule ]
  })
export class billingRoutingModule {}
  