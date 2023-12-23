import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Movie} from "../interfaces/movie.interface";

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private _http: HttpClient) {
  }


  getAllMovies(): Observable<Movie[]> {
    return this._http.get<Movie[]>("/api/movie")
  }

}
