import { TestBed } from '@angular/core/testing';

import { ServicePlatoService } from './service-plato.service';

describe('ServicePlatoService', () => {
  let service: ServicePlatoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServicePlatoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
