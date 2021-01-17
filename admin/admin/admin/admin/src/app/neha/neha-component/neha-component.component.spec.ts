import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NehaComponentComponent } from './neha-component.component';

describe('NehaComponentComponent', () => {
  let component: NehaComponentComponent;
  let fixture: ComponentFixture<NehaComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NehaComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NehaComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
