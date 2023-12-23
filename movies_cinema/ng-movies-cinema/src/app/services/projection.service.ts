import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Movie} from "../interfaces/movie.interface";
import {Projection} from "../interfaces/projection.interface";

@Injectable({
  providedIn: 'root'
})
export class ProjectionService {

  readonly path = "api/projection"

  constructor(private _http: HttpClient) {
  }


  getAllProjectionsForMovie(movieId: number): Observable<Projection[]> {
    let params = new HttpParams();
    params = params.set("movieId", movieId)
    return this._http.get<Projection[]>(`${this.path}`, {params})
  }


}
