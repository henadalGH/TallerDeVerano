import { TestBed } from '@angular/core/testing';

import { ServiceServicieService } from './service-servicie.service';

describe('ServiceServicieService', () => {
  let service: ServiceServicieService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceServicieService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
