import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {BoughtTicketInfo, Ticket} from "../interfaces/ticket.interface";

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

  getAllTicketsByCustomerId(customerId: number): Observable<BoughtTicketInfo[]> {
    let params = new HttpParams();
    params = params.set("customerId", customerId)
    return this._http.get<BoughtTicketInfo[]>(`${this.path}`, {params})
  }

  customerBuysTicket(customerId: number, ticketId: number, paymentMethod: string): Observable<any> {
    return this._http.post<any>(`${this.path}`, {customerId, ticketId, paymentMethod})
  }
}
