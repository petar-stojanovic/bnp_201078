import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../services/customer.service";
import {Customer} from "../../interfaces/customer.interface";
import {forkJoin} from "rxjs";
import {TicketService} from "../../services/ticket.service";
import {BoughtTicketInfo} from "../../interfaces/ticket.interface";
import {BuyTicketDialog} from "../../dialogs/buy-ticket-dialog/buy-ticket-dialog";
import {MatDialog} from "@angular/material/dialog";
import {CreateCustomerDialog} from "../../dialogs/create-customer-dialog/create-customer-dialog";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  displayedColumns: string[] = [
    "poster",
    "movieTitle",
    "date",
    "time",
    "ticketPrice",
    "paymentMethod",
    "rowNumber",
    "colNumber",
    "screenType",
    "cinemaName",
  ];

  customers: Customer[] | null = null
  selectedCustomer = this.customers?.at(0);

  tickets: BoughtTicketInfo[] | null = null;

  loggedInUserId = localStorage.getItem("userId")
  firstName = localStorage.getItem("firstName")
  lastName = localStorage.getItem("lastName")

  constructor(private _customerService: CustomerService,
              private _ticketService: TicketService,
              public dialog: MatDialog,
              private router: Router) {

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

  openDialog() {

    const dialogRef = this.dialog.open(CreateCustomerDialog);

    dialogRef.afterClosed().subscribe(it => {
      console.log('The  ', it);
      if (it !== undefined) {
        this._customerService.createCustomer(it.firstName, it.lastName, it.sex, it.age).subscribe(_ => {
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
