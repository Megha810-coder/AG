import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NehaComponentComponent } from './neha-component/neha-component.component';
import { NehaRoutingModule } from './neha-routing.module';

@NgModule({
  declarations: [NehaComponentComponent],
  exports:[NehaComponentComponent],
  imports: [
    CommonModule,NehaRoutingModule
  ]
})
export class NehaModule { }
