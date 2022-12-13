import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdenarComponent } from './ordenar.component';

describe('OrdenarComponent', () => {
  let component: OrdenarComponent;
  let fixture: ComponentFixture<OrdenarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrdenarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdenarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
