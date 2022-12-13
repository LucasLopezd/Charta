import { TestBed } from '@angular/core/testing';

import { HojaService } from './hoja.service';

describe('HojaService', () => {
  let service: HojaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HojaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
