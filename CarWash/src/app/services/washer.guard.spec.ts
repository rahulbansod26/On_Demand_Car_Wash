import { TestBed } from '@angular/core/testing';

import { WasherGuard } from './washer.guard';

describe('WasherGuard', () => {
  let guard: WasherGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(WasherGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
