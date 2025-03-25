import { TestBed } from '@angular/core/testing';

import { ResevasService } from './resevas.service';

describe('ResevasService', () => {
  let service: ResevasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResevasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
