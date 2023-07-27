import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsWelcomeComponent } from './us-welcome.component';

describe('UsWelcomeComponent', () => {
  let component: UsWelcomeComponent;
  let fixture: ComponentFixture<UsWelcomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsWelcomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UsWelcomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
