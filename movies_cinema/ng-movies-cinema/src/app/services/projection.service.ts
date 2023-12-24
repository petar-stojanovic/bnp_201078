import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Movie} from "../interfaces/movie.interface";
import {Projection} from "../interfaces/projection.interface";
import {Hall} from "../interfaces/hall.interface";
import {MovieRequest} from "../interfaces/movie-request.interface";
import {Cinema} from "../interfaces/cinema.interface";

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


  getHallsByCinemaId(cinemaId: number): Observable<Hall[]> {
    let params = new HttpParams();
    params = params.set("cinemaId", cinemaId)
    return this._http.get<Hall[]>(`${this.path}/halls`, {params})
  }

  getAllCinemas(): Observable<Cinema[]> {
    return this._http.get<Cinema[]>(`${this.path}/cinemas`)
  }

  saveProjection(req: any) {
    return this._http.post<any>(`${this.path}`, req)
  }
}
