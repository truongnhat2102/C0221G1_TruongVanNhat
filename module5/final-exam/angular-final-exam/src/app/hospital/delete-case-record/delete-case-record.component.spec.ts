import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteCaseRecordComponent } from './delete-case-record.component';

describe('DeleteCaseRecordComponent', () => {
  let component: DeleteCaseRecordComponent;
  let fixture: ComponentFixture<DeleteCaseRecordComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteCaseRecordComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteCaseRecordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
