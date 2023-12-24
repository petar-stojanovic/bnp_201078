import {Component, OnInit} from '@angular/core';
import {forkJoin} from "rxjs";
import {StatisticsService} from "../../services/statistics.service";
import {
  MostFrequentCustomer,
  MostPopularGenre,
  MostPopularMovieTime,
  MostProfitableMovies,
  MostViewedMovies
} from "../../interfaces/statistics.interface";

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

  mostViewedMoviesColumns: string[] = [
    'poster',
    'title',
    'ticketCount',
  ];

  mostPopularGenreColumns: string[] = [
    'name',
    'ticketCount'
  ];

  mostFrequentCustomerColumns: string[] = [
    'firstName',
    'lastName',
    'ticketCount',
  ];

  mostProfitableMoviesColumns: string[] = [
    'poster',
    'title',
    'totalRevenue',
  ];

  mostPopularMovieTimeColumns: string[] = [
    'projectionTime',
    'ticketCount'
  ];

  mostFrequentCustomers: MostFrequentCustomer[] = []
  mostPopularGenres: MostPopularGenre[] = []
  mostPopularMovieTimes: MostPopularMovieTime[] = []
  mostProfitableMovies: MostProfitableMovies[] = []
  mostViewedMovies: MostViewedMovies[] = []

  constructor(
    private _statisticsService: StatisticsService,
  ) {
  }


  ngOnInit(): void {
    forkJoin({
      mostFrequentCustomers: this._statisticsService.findMostFrequentCustomers(),
      mostPopularGenres: this._statisticsService.findMostPopularGenres(),
      mostPopularMovieTimes: this._statisticsService.findMostPopularMovieTimes(),
      mostProfitableMovies: this._statisticsService.findMostProfitableMovies(),
      mostViewedMovies: this._statisticsService.findMostViewedMovies(),
    }).subscribe(it => {
      console.log(it)
      this.mostFrequentCustomers = it.mostFrequentCustomers
      this.mostPopularGenres = it.mostPopularGenres
      this.mostPopularMovieTimes = it.mostPopularMovieTimes
      this.mostProfitableMovies = it.mostProfitableMovies
      this.mostViewedMovies = it.mostViewedMovies
    })
  }

}
