import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsSidebarComponent } from './us-sidebar.component';

describe('UsSidebarComponent', () => {
  let component: UsSidebarComponent;
  let fixture: ComponentFixture<UsSidebarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsSidebarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UsSidebarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
