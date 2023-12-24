import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ProjectionService} from "../../services/projection.service";
import {Projection} from "../../interfaces/projection.interface";
import {Movie} from "../../interfaces/movie.interface";
import {forkJoin} from "rxjs";
import {MovieService} from "../../services/movie.service";
import {CreateCustomerDialog} from "../../dialogs/create-customer-dialog/create-customer-dialog";
import {MatDialog} from "@angular/material/dialog";
import {AddProjectionDialog} from "../../dialogs/add-projection-dialog/add-projection-dialog";


@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {

  displayedColumns: string[] = [
    'cinemaName',
    'date',
    'time',
    'hallNumber',
    'screenType',
    'startPrice',
    'action'
  ];
  movieId = 0
  movie: Movie | null = null
  projections: Projection[] | null = null

  constructor(
    private _projectionService: ProjectionService,
    private _movieService: MovieService,
    private route: ActivatedRoute,
    private router: Router,
    public dialog: MatDialog
  ) {
    this.movieId = +this.route.snapshot.paramMap.get('movieId')!!;
  }

  ngOnInit(): void {
    forkJoin({
      movie: this._movieService.getMovieById(this.movieId),
      projections: this._projectionService.getAllProjectionsForMovie(this.movieId)
    }).subscribe(it => {
      if (it.movie === null) {
        this.router.navigate([""])
      }
      console.log(it)
      this.movie = it.movie;
      this.projections = it.projections
    })


  }

  openDialog() {

    const dialogRef = this.dialog.open(AddProjectionDialog, {
      data: {
        movieId: this.movie!.movieId
      }
    });

    dialogRef.afterClosed().subscribe(it => {
      if (it !== undefined) {
        console.log(it)
        this._projectionService.saveProjection(it).subscribe(_ => {
          this.reloadCurrentRoute()
        })
      }
    });
  }

  reloadCurrentRoute() {
    let currentUrl = this.router.url;
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
      this.router.navigate([currentUrl]);
    });
  }
}
