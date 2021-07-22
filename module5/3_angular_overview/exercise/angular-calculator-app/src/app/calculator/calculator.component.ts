import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  result = 0;
  constructor() { }

  ngOnInit(): void {
  }

  add(num1: string, num2: string) {
    // tslint:disable-next-line:radix
    this.result = parseInt(num1) + parseInt(num2);
    document.getElementById('result').innerHTML =  this.result.toString();
  }

  decrease(num1: string, num2: string) {
    // tslint:disable-next-line:radix
    this.result = parseInt(num1) - parseInt(num2);
    document.getElementById('result').innerHTML =  this.result.toString();
  }

  multi(num1: string, num2: string) {
    // tslint:disable-next-line:radix
    this.result = parseInt(num1) * parseInt(num2);
    document.getElementById('result').innerHTML =  this.result.toString();
  }

  division(num1: string, num2: string) {
    // tslint:disable-next-line:radix
    this.result = parseInt(num1) / parseInt(num2);
    document.getElementById('result').innerHTML =  this.result.toString();
  }

  addSign(sign: string, expression: string) {
    const expr = expression.concat(sign);
    document.getElementById('input').innerHTML = expr;
  }
}
