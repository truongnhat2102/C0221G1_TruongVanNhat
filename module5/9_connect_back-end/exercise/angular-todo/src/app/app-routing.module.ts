import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TodoListComponent} from "./todo/todo-list/todo-list.component";
import {TodoCreateComponent} from "./todo/todo-create/todo-create.component";
import {TodoEditComponent} from "./todo/todo-edit/todo-edit.component";
import {TodoDeleteComponent} from "./todo/todo-delete/todo-delete.component";


const routes: Routes = [{
  path: 'todo/list',
  component: TodoListComponent
}, {
  path: 'todo/create',
  component: TodoCreateComponent
}, {
  path: 'todo/edit/:id',
  component: TodoEditComponent
}, {
  path: 'todo/delete/:id',
  component: TodoDeleteComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
