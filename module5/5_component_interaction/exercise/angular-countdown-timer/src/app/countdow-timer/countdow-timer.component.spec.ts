import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CountdowTimerComponent } from './countdow-timer.component';

describe('CountdowTimerComponent', () => {
  let component: CountdowTimerComponent;
  let fixture: ComponentFixture<CountdowTimerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CountdowTimerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CountdowTimerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
