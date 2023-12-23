import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ProjectionService} from "../../services/projection.service";
import {Projection} from "../../interfaces/projection.interface";
import {Movie} from "../../interfaces/movie.interface";
import {forkJoin, mergeMap} from "rxjs";
import {MovieService} from "../../services/movie.service";

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {

  movieId = 0
  movie: Movie | null = null
  projections: Projection[] | null = null

  constructor(
    private _projectionService: ProjectionService,
    private _movieService: MovieService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.movieId = +this.route.snapshot.paramMap.get('movieId')!!;
  }

  ngOnInit(): void {
    console.log(this.route.snapshot.paramMap.get('movieId'))


    forkJoin({
      movie: this._movieService.getMovieById(this.movieId),
      projections: this._projectionService.getAllProjectionsForMovie(this.movieId)
    }).subscribe(it => {
      if (it.movie === null) {
        this.router.navigate([""])
      }
      this.movie = it.movie;
      this.projections = it.projections
    })



  }

}
