import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerBillFormComponent } from './customer-bill-form.component';

describe('CustomerBillFormComponent', () => {
  let component: CustomerBillFormComponent;
  let fixture: ComponentFixture<CustomerBillFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerBillFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerBillFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
