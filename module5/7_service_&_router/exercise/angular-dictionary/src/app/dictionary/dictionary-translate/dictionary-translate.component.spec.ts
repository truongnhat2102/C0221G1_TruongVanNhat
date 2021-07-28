import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DictionaryTranslateComponent } from './dictionary-translate.component';

describe('DictionaryTranslateComponent', () => {
  let component: DictionaryTranslateComponent;
  let fixture: ComponentFixture<DictionaryTranslateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DictionaryTranslateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DictionaryTranslateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
