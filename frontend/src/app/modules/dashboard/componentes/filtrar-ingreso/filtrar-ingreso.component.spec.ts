import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FiltrarIngresoComponent } from './filtrar-ingreso.component';

describe('FiltrarIngresoComponent', () => {
  let component: FiltrarIngresoComponent;
  let fixture: ComponentFixture<FiltrarIngresoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FiltrarIngresoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FiltrarIngresoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
