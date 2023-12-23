import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ticket} from "../interfaces/ticket.interface";

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  readonly path = "api/ticket"

  constructor(private _http: HttpClient) {
  }


  getAllTicketsProjection(projectionId: number): Observable<Ticket[]> {
    let params = new HttpParams();
    params = params.set("projectionId", projectionId)
    return this._http.get<Ticket[]>(`${this.path}`, {params})
  }

}
