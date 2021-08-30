import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TodoListComponent} from "./todo/todo-list/todo-list.component";
import {TodoCreateComponent} from "./todo/todo-create/todo-create.component";
import {TodoEditComponent} from "./todo/todo-edit/todo-edit.component";
import {TodoDeleteComponent} from "./todo/todo-delete/todo-delete.component";


const routes: Routes = [{
  path: 'todoes/list',
  component: TodoListComponent
}, {
  path: 'todoes/create',
  component: TodoCreateComponent
}, {
  path: 'todoes/edit/:id',
  component: TodoEditComponent
}, {
  path: 'todoes/delete/:id',
  component: TodoDeleteComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
