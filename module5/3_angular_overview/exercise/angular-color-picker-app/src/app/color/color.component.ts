import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
  color1 = 'violet';

  constructor() { }

  ngOnInit(): void {
  }

  changeColor(color) {
    this.color1 = color.value;
  }

}
