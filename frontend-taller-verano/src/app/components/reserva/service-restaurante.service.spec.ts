import { TestBed } from '@angular/core/testing';

import { ServiceRestauranteService } from './service-restaurante.service';

describe('ServiceRestauranteService', () => {
  let service: ServiceRestauranteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceRestauranteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
