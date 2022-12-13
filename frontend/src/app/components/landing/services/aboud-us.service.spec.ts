import { TestBed } from '@angular/core/testing';

import { AboudUSService } from './aboud-us.service';

describe('AboudUSService', () => {
  let service: AboudUSService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AboudUSService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
