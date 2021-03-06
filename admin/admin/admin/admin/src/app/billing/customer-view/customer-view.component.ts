import { Component, OnInit } from '@angular/core';
import { BillService } from '../../bill.service';
import { Bill } from '../../bill';

@Component({
  selector: 'app-customer-view',
  templateUrl: './customer-view.component.html',
  styleUrls: ['./customer-view.component.scss']
})
export class CustomerViewComponent implements OnInit {

  private bill:Bill;
  constructor(private billService:BillService) { }

  ngOnInit() {
    this.bill= this.billService.getter();
  }

}
