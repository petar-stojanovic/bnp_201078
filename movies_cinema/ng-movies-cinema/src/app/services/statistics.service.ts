import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {
  MostFrequentCustomer,
  MostPopularGenre,
  MostPopularMovieTime,
  MostProfitableMovies, MostViewedMovies
} from "../interfaces/statistics.interface";

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {
  readonly path = "api/statistics"

  constructor(private _http: HttpClient) {
  }

  findMostFrequentCustomers(): Observable<MostFrequentCustomer[]> {
    return this._http.get<MostFrequentCustomer[]>(`${this.path}/findMostFrequentCustomers`)
  }

  findMostPopularGenres(): Observable<MostPopularGenre[]> {
    return this._http.get<MostPopularGenre[]>(`${this.path}/findMostPopularGenres`)
  }

  findMostPopularMovieTimes(): Observable<MostPopularMovieTime[]> {
    return this._http.get<MostPopularMovieTime[]>(`${this.path}/findMostPopularMovieTimes`)
  }

  findMostProfitableMovies(): Observable<MostProfitableMovies[]> {
    return this._http.get<MostProfitableMovies[]>(`${this.path}/findMostProfitableMovies`)
  }

  findMostViewedMovies(): Observable<MostViewedMovies[]> {
    return this._http.get<MostViewedMovies[]>(`${this.path}/findMostViewedMovies`)
  }

}
