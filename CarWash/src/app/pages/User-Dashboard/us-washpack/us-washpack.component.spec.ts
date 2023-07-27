import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsWashpackComponent } from './us-washpack.component';

describe('UsWashpackComponent', () => {
  let component: UsWashpackComponent;
  let fixture: ComponentFixture<UsWashpackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsWashpackComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UsWashpackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
