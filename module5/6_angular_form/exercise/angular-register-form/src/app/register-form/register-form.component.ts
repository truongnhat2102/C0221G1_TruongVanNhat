import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  currentYear = new Date().getFullYear();

  user = new FormGroup({
    id: new FormControl('',[Validators.required]),
    email: new FormControl('',[Validators.required, Validators.pattern("^[a-zA-Z0-9]{1,}[@][a-z.]{1,}$")]),
    password: new FormControl('',[Validators.required, Validators.pattern("[a-zA-Z0-9]{8,}")]),
    country: new FormControl('',[Validators.required]),
    age: new FormControl('',[Validators.required]),
    gender: new FormControl('',[Validators.required]),
    phone: new FormControl('',[Validators.required, Validators.pattern("^(?:\\+?(09))? ?(?:\\((?=.*\\)))?(0?[2-57-8])\\)? ?(\\d\\d(?:[- ](?=\\d{3})|(?!\\d\\d[- ]?\\d[- ]))\\d\\d[- ]?\\d[- ]?\\d{3})$")])
});

  constructor() { }

  ngOnInit(): void {
  }

  createUser() {
    console.log(this.currentYear);
    console.log(this.user.value);
  }

}
