import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateWashpackComponent } from './update-washpack.component';

describe('UpdateWashpackComponent', () => {
  let component: UpdateWashpackComponent;
  let fixture: ComponentFixture<UpdateWashpackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateWashpackComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateWashpackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
