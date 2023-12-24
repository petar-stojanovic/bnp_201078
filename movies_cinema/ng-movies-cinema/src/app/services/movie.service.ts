import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Movie} from "../interfaces/movie.interface";
import {MovieRequest} from "../interfaces/movie-request.interface";

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  readonly path = 'api/movie'
  constructor(private _http: HttpClient) {
  }


  getAllMovies(): Observable<Movie[]> {
    return this._http.get<Movie[]>(`${this.path}`)
  }

  getMovieById(movieId: number): Observable<Movie> {
    let params = new HttpParams();
    params = params.set("movieId", movieId)
    return this._http.get<Movie>(`${this.path}`, {params})
  }

  saveMovie(req: MovieRequest){
    return this._http.post<any>(`${this.path}`, req)
  }
}
