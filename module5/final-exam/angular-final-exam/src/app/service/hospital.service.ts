import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CaseRecord} from "../model/case-record";

@Injectable({
  providedIn: 'root'
})
export class HospitalService {

  API_URL = 'http://localhost:3000';

  constructor(private httpClient: HttpClient) { }

  getAllCaseRecord(): Observable<CaseRecord[]> {
    return this.httpClient.get<CaseRecord[]>(this.API_URL + '/case-record');
  }

  findRecordById(id: string): Observable<CaseRecord> {
    return this.httpClient.get<CaseRecord>(`${this.API_URL}/case-record/${id}`);
  }

  saveRecord(caseRecord: CaseRecord): Observable<CaseRecord> {
    return this.httpClient.post<CaseRecord>(this.API_URL + '/case-record', caseRecord);
  }

  updateRecord(id: string, caseRecord: CaseRecord): Observable<CaseRecord> {
    return this.httpClient.put<CaseRecord>(`${this.API_URL}/case-record/${id}`, caseRecord);
  }

  deleteRecord(id: string): Observable<CaseRecord> {
    return this.httpClient.delete<CaseRecord>(`${this.API_URL}/case-record/${id}`);
  }

}
