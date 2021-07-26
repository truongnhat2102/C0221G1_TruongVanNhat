import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {User} from "../user";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  @Input() user: User;
  @Output() submitCreateUser = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  createUser(createUser: NgForm) {
    // this.submitCreateUser.emit(this.user);
    console.log(createUser.value);
  }

}
