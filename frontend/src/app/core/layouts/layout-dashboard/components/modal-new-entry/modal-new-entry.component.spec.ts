import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalNewEntryComponent } from './modal-new-entry.component';

describe('ModalNewEntryComponent', () => {
  let component: ModalNewEntryComponent;
  let fixture: ComponentFixture<ModalNewEntryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalNewEntryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalNewEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
