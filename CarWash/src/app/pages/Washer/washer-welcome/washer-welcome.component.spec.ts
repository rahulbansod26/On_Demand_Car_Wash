import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WasherWelcomeComponent } from './washer-welcome.component';

describe('WasherWelcomeComponent', () => {
  let component: WasherWelcomeComponent;
  let fixture: ComponentFixture<WasherWelcomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WasherWelcomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WasherWelcomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
