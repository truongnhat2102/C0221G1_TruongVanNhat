import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {TodoService} from "../../service/todo.service";
import {Todo} from "../../model/todo";

@Component({
  selector: 'app-todo-create',
  templateUrl: './todo-create.component.html',
  styleUrls: ['./todo-create.component.css']
})
export class TodoCreateComponent implements OnInit {

  todoForm: FormGroup = new FormGroup({
      id: new FormControl(),
      title: new FormControl(),
      content: new FormControl()
    });

  constructor(private todoService: TodoService) { }

  ngOnInit(): void {
  }

  submit() {
    const todo = this.todoForm.value;
    this.todoService.saveTodo(todo).subscribe(() => {
      this.todoForm.reset();
      alert('success');
    }, e => {
      console.log(e);
    });
  }

}
