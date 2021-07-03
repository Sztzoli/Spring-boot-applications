import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Beer} from "./home/home.component";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get('http://localhost:8081/good-beers');
  }
}
