import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-create-customer-dialog',
  templateUrl: './create-customer-dialog.html',
  styleUrls: ['./create-customer-dialog.css']
})
export class CreateCustomerDialog {

  firstName = "";
  lastName = "";
  sex = "";
  age = 0;

  constructor(
    public dialogRef: MatDialogRef<CreateCustomerDialog>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {
  }


  onSubmit(customerForm: NgForm) {
    this.dialogRef.close(customerForm.value)
  }
}
