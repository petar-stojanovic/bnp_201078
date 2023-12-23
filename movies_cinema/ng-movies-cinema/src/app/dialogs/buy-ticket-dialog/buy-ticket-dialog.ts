import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {PaymentTypes} from "../../interfaces/payment-types.enum";

@Component({
  selector: 'app-buy-ticket-dialog',
  templateUrl: './buy-ticket-dialog.html',
  styleUrls: ['./buy-ticket-dialog.css']
})
export class BuyTicketDialog {

  availableMethods = [PaymentTypes.CASH, PaymentTypes.CREDIT_CARD, PaymentTypes.DEBIT_CARD];
  selected = PaymentTypes.CASH

  constructor(
    public dialogRef: MatDialogRef<BuyTicketDialog>,
    @Inject(MAT_DIALOG_DATA) public data: {
      ticketId: number,
      firstName: string,
      lastName: string,
      movie: string
    },
  ) {

  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
