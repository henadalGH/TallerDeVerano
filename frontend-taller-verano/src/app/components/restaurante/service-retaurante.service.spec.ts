import { TestBed } from '@angular/core/testing';

import { ServiceRetauranteService } from './service-retaurante.service';

describe('ServiceRetauranteService', () => {
  let service: ServiceRetauranteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceRetauranteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
