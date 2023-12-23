import {Component, OnInit} from '@angular/core';
import {Movie} from "../../interfaces/movie.interface";
import {Projection} from "../../interfaces/projection.interface";
import {ProjectionService} from "../../services/projection.service";
import {MovieService} from "../../services/movie.service";
import {ActivatedRoute, Router} from "@angular/router";
import {DatePipe} from "@angular/common";
import {forkJoin, switchMap} from "rxjs";
import {Ticket} from "../../interfaces/ticket.interface";
import {TicketService} from "../../services/ticket.service";

@Component({
  selector: 'app-projection-details',
  templateUrl: './projection-details.component.html',
  styleUrls: ['./projection-details.component.css']
})
export class ProjectionDetailsComponent implements OnInit {

  displayedColumns: string[] = [
    'id',
    'date',
    'time',
    'hallNumber',
    'screenType',
    'startPrice',
    'action'
  ];
  movieId = 0
  projectionId = 0
  movie: Movie | null = null
  tickets: Ticket[] | null = null

  constructor(
    private _ticketService: TicketService,
    private _movieService: MovieService,
    private route: ActivatedRoute,
    private router: Router,
  ) {
    this.movieId = +this.route.snapshot.paramMap.get('movieId')!!;
    this.projectionId = +this.route.snapshot.paramMap.get('projectionId')!!;
  }

  ngOnInit(): void {
    forkJoin({
      movie: this._movieService.getMovieById(this.movieId),
      tickets: this._ticketService.getAllTicketsProjection(this.projectionId)
    }).subscribe(it => {
      if (it.movie === null) {
        this.router.navigate([""])
      }
      this.movie = it.movie;
      this.tickets = it.tickets

      console.log(it.movie)
      console.log(it.tickets)
    })
  }

}
