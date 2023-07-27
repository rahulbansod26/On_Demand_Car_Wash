import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsWashpackComponents } from './us-washpack.components';

describe('UsWashpackComponents', () => {
  let component: UsWashpackComponents;
  let fixture: ComponentFixture<UsWashpackComponents>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsWashpackComponents ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UsWashpackComponents);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
