import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestauranteDetalleComponent } from './restaurante-detalle.component';

describe('RestauranteDetalleComponent', () => {
  let component: RestauranteDetalleComponent;
  let fixture: ComponentFixture<RestauranteDetalleComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RestauranteDetalleComponent]
    });
    fixture = TestBed.createComponent(RestauranteDetalleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
