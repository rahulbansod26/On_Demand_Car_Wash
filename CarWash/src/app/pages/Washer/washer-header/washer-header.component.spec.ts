import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WasherHeaderComponent } from './washer-header.component';

describe('WasherHeaderComponent', () => {
  let component: WasherHeaderComponent;
  let fixture: ComponentFixture<WasherHeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WasherHeaderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WasherHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
