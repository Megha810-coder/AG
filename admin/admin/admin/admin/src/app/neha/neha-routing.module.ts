import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NehaComponentComponent } from './neha-component/neha-component.component';

export const routes: Routes = [
    {
    path: '',
    data: {
      title: 'neha'
    },
    children: [
     {
         path:'',
         redirectTo:'Job'
     },
      {
        path: 'Job',
        component: NehaComponentComponent,
        data: {
          title: 'Job'
        }
      },
    
    ]
  }

];
@NgModule({
    imports: [ RouterModule.forChild(routes) ],
    exports: [ RouterModule ]
  })
export class NehaRoutingModule {}
  