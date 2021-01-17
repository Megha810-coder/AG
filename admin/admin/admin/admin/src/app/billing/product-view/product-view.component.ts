import { Component, OnInit } from '@angular/core';
import { BillService } from '../../bill.service';
import { Bill } from '../../bill';

@Component({
  selector: 'app-product-view',
  templateUrl: './product-view.component.html',
  styleUrls: ['./product-view.component.scss']
})
export class ProductViewComponent implements OnInit {

  private bill:Bill;
  constructor(private billService:BillService) { }

  ngOnInit() {
    this.bill= this.billService.getter();
  }

}
