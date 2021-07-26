import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-countdow-timer',
  templateUrl: './countdow-timer.component.html',
  styleUrls: ['./countdow-timer.component.css']
})
export class CountdowTimerComponent implements OnInit {

  @Input() time: number;
  check = false;

  constructor() {
  }

  ngOnInit(): void {
  }

  countdown() {
    let interval = setInterval(() => {
      if (this.check) {
        console.log('pause');
        clearInterval(interval);
      } else {
        this.time = this.time - 1;
        console.log(this.time);
      }
    }, 1000);

  }

  countup() {
    let interval = setInterval(() => {
      if (this.check) {
        console.log('pause')
        clearInterval(interval);
      } else {
        this.time = this.time - -1;
      }
    }, 1000);
  }

  pause() {
    if (!this.check) {
      this.check = true;
    } else {
      this.check = false;
    }

  }

}
