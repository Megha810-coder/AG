import { Component, OnInit } from '@angular/core';
import { Bill } from '../../bill';
import { BillService } from '../../bill.service';

@Component({
  selector: 'app-vendors-view',
  templateUrl: './vendors-view.component.html',
  styleUrls: ['./vendors-view.component.scss']
})
export class VendorsViewComponent implements OnInit {

  private bill:Bill;
  constructor(private billService:BillService) { }

  ngOnInit() {
    this.bill= this.billService.getter();
  }

}