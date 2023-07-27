import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WashpacksComponent } from './washpacks.component';

describe('WashpacksComponent', () => {
  let component: WashpacksComponent;
  let fixture: ComponentFixture<WashpacksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WashpacksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WashpacksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
