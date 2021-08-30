import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {TodoService} from "../../service/todo.service";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-todo-delete',
  templateUrl: './todo-delete.component.html',
  styleUrls: ['./todo-delete.component.css']
})
export class TodoDeleteComponent implements OnInit {

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

  delete(id: string) {
    this.todoService.deleteTodo(id).subscribe(() => {
      alert('success');
    }, e => {
      console.log(e);
    });
  }

}
