import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Todo} from "../model/todo";

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  API_URL = 'http://localhost:3000';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Todo[]> {
    return this.http.get<Todo[]>(this.API_URL + '/todoes');
  }

  saveTodo(todo: Todo): Observable<Todo> {
    return this.http.post<Todo>(this.API_URL + '/todoes', todo);
  }

  findById(id: string): Observable<Todo> {
    return this.http.get<Todo>(`${this.API_URL}/todoes/${id}`);
  }

  updateTodo(id: string, todo: Todo): Observable<Todo> {
    return this.http.put<Todo>(`${this.API_URL}/todoes/${id}`, todo);
  }

  deleteTodo(id: string): Observable<Todo> {
    return this.http.delete<Todo>(`${this.API_URL}/todoes/${id}`);
  }

}
