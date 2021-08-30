import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {TodoService} from "../../service/todo.service";
import {Todo} from "../../model/todo";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-todo-edit',
  templateUrl: './todo-edit.component.html',
  styleUrls: ['./todo-edit.component.css']
})
export class TodoEditComponent implements OnInit {

  id: string;

  todoForm: FormGroup;

  constructor(private todoService: TodoService,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = paramMap.get('id');
      this.getTodo(this.id);
    })
  }

  ngOnInit(): void {
  }

  getTodo(id: string){
    return this.todoService.findById(id).subscribe(todo => {
      this.todoForm = new FormGroup({
        id: new FormControl(todo.id),
        title: new FormControl(todo.title),
        content: new FormControl(todo.content)
      });
    });
  }

  update(id: string) {
    const todo = this.todoForm.value;
    this.todoService.updateTodo(id, todo).subscribe(() => {
      alert('success');
    }, e => {
      console.log(e);
    });
  }

}
