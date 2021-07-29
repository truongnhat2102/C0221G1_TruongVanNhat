import { Component, OnInit } from '@angular/core';
import {Todo} from "../../model/todo";
import {TodoService} from "../../service/todo.service";

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {

  todos: Todo[] = [{
    id: '1',
    title: 'blabla',
    content: 'ahihi'
  }, {
    id: '2',
    title: 'bleble',
    content: 'ahoho'
  }, {
    id: '1',
    title: 'blibli',
    content: 'ahaha'
  }];

  constructor(private todoService: TodoService) { }

  ngOnInit(): void {
    this.getAll()
  }

  private getAll() {
    this.todoService.getAll().subscribe(todo => {
      this.todos = todo;
    });
  }
}
