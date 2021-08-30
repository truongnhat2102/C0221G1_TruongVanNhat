import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCaseRecordComponent } from './update-case-record.component';

describe('UpdateCaseRecordComponent', () => {
  let component: UpdateCaseRecordComponent;
  let fixture: ComponentFixture<UpdateCaseRecordComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateCaseRecordComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateCaseRecordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
