import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../interfaces/customer.interface";

@Injectable({
  providedIn: 'root'
})
export class GenreService {

  readonly path = 'api/genre'

  constructor(private _http: HttpClient) {
  }


  getAllGenres(): Observable<{ id: number, name: string }[]> {
    return this._http.get<{ id: number, name: string }[]>(`${this.path}`)
  }

}
