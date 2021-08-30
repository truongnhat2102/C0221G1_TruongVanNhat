import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  API_URL = 'http://localhost:3000';

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Customer[]> {
      return this.httpClient.get<Customer[]>(this.API_URL + '/customer');
  }

  findById(id: string): Observable<Customer> {
    return this.httpClient.get<Customer>(`${this.API_URL}/customer/${id}`);
  }

  findByCategory(id: number): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.API_URL + `/customer?idTypeCustomer=${id}`);
  }

  saveCustomer(customer: Customer): Observable<Customer> {
    return this.httpClient.post<Customer>(this.API_URL + '/customer', customer);
  }

  updateCustomer(id: string, customer: Customer): Observable<Customer> {
    return this.httpClient.put<Customer>(`${this.API_URL}/customer/${id}`, customer);
  }

  deleteCustomer(id: string): Observable<Customer> {
    return this.httpClient.delete<Customer>(`${this.API_URL}/customer/${id}`);
  }

  findByName(name: string): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(`${this.API_URL}/customer/customer?name=${name}`);
  }

}
