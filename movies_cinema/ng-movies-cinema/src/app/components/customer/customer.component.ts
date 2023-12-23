import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../services/customer.service";
import {Customer} from "../../interfaces/customer.interface";
import {forkJoin} from "rxjs";
import {TicketService} from "../../services/ticket.service";
import {Ticket} from "../../interfaces/ticket.interface";
import {TicketDetails} from "../../interfaces/ticket-details.interface";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {


  customers: Customer[] | null = null
  selectedCustomer = this.customers?.at(0);

  tickets: TicketDetails[] | null = null;

  loggedInUserId = localStorage.getItem("userId")
  firstName = localStorage.getItem("firstName")
  lastName = localStorage.getItem("lastName")

  constructor(private _customerService: CustomerService,
              private _ticketService: TicketService) {

    console.log(localStorage)
    console.log(this.loggedInUserId)
  }

  ngOnInit(): void {
    this._customerService.getAllCustomers().subscribe(customers => {
      console.log(customers)
      this.customers = customers;
      this.selectedCustomer = this.customers?.at(0);
    })

    if (this.loggedInUserId != null) {
      forkJoin({
        customers: this._customerService.getAllCustomers(),
        tickets: this._ticketService.getAllTicketsByCustomerId(+this.loggedInUserId)
      }).subscribe(it => {

        this.customers = it.customers
        this.tickets = it.tickets
        console.log(this.tickets)
      })
    } else {
      this._customerService.getAllCustomers().subscribe(customers => {
        this.customers = customers
      })
    }
  }


  login() {
    console.log(this.selectedCustomer)
    const customerId = this.selectedCustomer!!.id
    this._customerService.getCustomerById(customerId).subscribe(customer => {
      localStorage.setItem("userId", customer.id.toString())
      localStorage.setItem("firstName", customer.firstName)
      localStorage.setItem("lastName", customer.lastName)
      location.reload();
    })
  }
}
