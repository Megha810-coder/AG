import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-purchase-bill',
  templateUrl: './purchase-bill.component.html',
  styleUrls: ['./purchase-bill.component.scss']
})
export class PurchaseBillComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }

  save(){
this.router.navigate(['/billing/Purchasebill-form']);
  }

}
