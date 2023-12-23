import {Component, OnInit} from '@angular/core';
import {Movie} from "../../interfaces/movie.interface";
import {Projection} from "../../interfaces/projection.interface";
import {ProjectionService} from "../../services/projection.service";
import {MovieService} from "../../services/movie.service";
import {ActivatedRoute, Router} from "@angular/router";
import {DatePipe} from "@angular/common";
import {forkJoin, last, switchMap} from "rxjs";
import {Ticket} from "../../interfaces/ticket.interface";
import {TicketService} from "../../services/ticket.service";
import {MatDialog} from "@angular/material/dialog";
import {BuyTicketDialog} from "../buy-ticket-dialog/buy-ticket-dialog";

export interface SimpleProjectionInfo {
  date: string;
  time: string;
  screenType: string;
  cinemaName: string;
  city: string;
  country: string;
  hallNumber: number
}

@Component({
  selector: 'app-projection-details',
  templateUrl: './projection-details.component.html',
  styleUrls: ['./projection-details.component.css']
})
export class ProjectionDetailsComponent implements OnInit {

  displayedColumns: string[] = [
    'seatRow',
    'seatNumber',
    'price',
    'action'
  ];
  movieId = 0
  projectionId = 0
  movie: Movie | null = null
  tickets: Ticket[] | null = null
  projectionInfo: SimpleProjectionInfo | null = null

  constructor(
    private _ticketService: TicketService,
    private _movieService: MovieService,
    private route: ActivatedRoute,
    private router: Router,
    public dialog: MatDialog
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
      this.projectionInfo = it.tickets[0] as unknown as SimpleProjectionInfo;
      this.projectionInfo.date = it.tickets[0].projectionTime.split("T")[0]
      this.projectionInfo.time = it.tickets[0].projectionTime.split("T")[1]


      console.log(it.movie)
      console.log(it.tickets)
    })
  }

  openDialog(id: number) {
    console.log(id)
    const loggedInUserId = localStorage.getItem("userId")
    const firstName = localStorage.getItem("firstName")
    const lastName = localStorage.getItem("lastName")


    const dialogRef = this.dialog.open(BuyTicketDialog, {
      data: {ticketId: id, firstName: firstName, lastName: lastName, movie: this.movie!.title},
    });

    dialogRef.afterClosed().subscribe(paymentMethod => {
      console.log('The dialog was closed ', paymentMethod);
      if (paymentMethod !== undefined) {
        this._ticketService.customerBuysTicket(+loggedInUserId!, id, paymentMethod).subscribe(_ => {
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
