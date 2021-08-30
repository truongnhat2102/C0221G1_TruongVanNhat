import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ManufacturerService {
  private API_MANUFACTURE = "http://localhost:8080/api/manufacturer";
  constructor(private http : HttpClient) { }

  // @ts-ignore
  getAllManufacturer(): Observable<any> {
    return this.http.get(this.API_MANUFACTURE);
  }
}
