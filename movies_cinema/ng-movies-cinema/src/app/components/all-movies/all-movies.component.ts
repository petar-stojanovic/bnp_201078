import {Component, OnInit} from '@angular/core';
import {MovieService} from "../../services/movie.service";

@Component({
  selector: 'app-all-movies',
  templateUrl: './all-movies.component.html',
  styleUrls: ['./all-movies.component.css']
})
export class AllMoviesComponent implements OnInit {

  constructor(private _service: MovieService) {

  }

  ngOnInit(): void {
    this._service.getAllMovies().subscribe(movies => {
      console.log(movies)
    })
  }

}
