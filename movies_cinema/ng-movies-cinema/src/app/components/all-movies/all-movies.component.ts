import {Component, OnInit} from '@angular/core';
import {MovieService} from "../../services/movie.service";
import {Movie} from "../../interfaces/movie.interface";

@Component({
  selector: 'app-all-movies',
  templateUrl: './all-movies.component.html',
  styleUrls: ['./all-movies.component.css']
})
export class AllMoviesComponent implements OnInit {

  movies: Movie[] | null = null

  constructor(private _service: MovieService) {

  }

  ngOnInit(): void {
    this._service.getAllMovies().subscribe(movies => {
      this.movies = movies;
    })
  }

}
