import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddWashpacksComponent } from './add-washpacks.component';

describe('AddWashpacksComponent', () => {
  let component: AddWashpacksComponent;
  let fixture: ComponentFixture<AddWashpacksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddWashpacksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddWashpacksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
