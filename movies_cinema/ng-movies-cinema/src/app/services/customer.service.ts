import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Movie} from "../interfaces/movie.interface";
import {Customer} from "../interfaces/customer.interface";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  readonly path = 'api/customer'

  constructor(private _http: HttpClient) {
  }


  getAllCustomers(): Observable<Customer[]> {
    return this._http.get<Customer[]>(`${this.path}`)
  }


  getCustomerById(customerId: number): Observable<Customer> {
    let params = new HttpParams();
    params = params.set("customerId", customerId)
    return this._http.get<Customer>(`${this.path}`, {params})
  }

}
