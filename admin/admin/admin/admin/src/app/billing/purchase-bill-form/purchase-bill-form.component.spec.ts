import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PurchaseBillFormComponent } from './purchase-bill-form.component';

describe('PurchaseBillFormComponent', () => {
  let component: PurchaseBillFormComponent;
  let fixture: ComponentFixture<PurchaseBillFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PurchaseBillFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PurchaseBillFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
