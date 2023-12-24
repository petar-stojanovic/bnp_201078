import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProjectionService} from "../../services/projection.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Hall} from "../../interfaces/hall.interface";
import {Cinema} from "../../interfaces/cinema.interface";

@Component({
  selector: 'add-projection-dialog',
  templateUrl: './add-projection-dialog.html',
  styleUrls: ['./add-projection-dialog.css']
})
export class AddProjectionDialog implements OnInit {

  today = "";


  projectionForm: FormGroup;
  availableCinemas: Cinema[] = []; // Replace with actual cinema data from the backend
  availableHalls: Hall[] = []; // Will be populated based on cinema selection
  movieId = 0

  @ViewChild('picker', {static: true}) pickerFixed?: any;

  constructor(public dialogRef: MatDialogRef<AddProjectionDialog>,
              @Inject(MAT_DIALOG_DATA) public data: any,
              private fb: FormBuilder,
              private _projectionService: ProjectionService) {
    this.projectionForm = this.fb.group({
      date_time: ['', Validators.required],
      id_cinema: ['', Validators.required],
      id_hall: ['', Validators.required],
      start_price: ['', Validators.required]
    });

    this.movieId = data.movieId;

  }

  ngOnInit() {
    this._projectionService.getAllCinemas().subscribe(cinemas => {
      this.availableCinemas = cinemas
    })

    const now = new Date();
    this.today = `${now.getFullYear()}-${(now.getMonth() + 1).toString().padStart(2, '0')}-${now.getDate().toString().padStart(2, '0')}`;
  }

  onCinemaSelectionChange() {
    // Implement logic to fetch halls based on the selected cinema (id_cinema)
    // You can make an HTTP request to the backend to get the halls for the selected cinema
    // Populate the availableHalls array with the fetched data
    // Example:
    if (this.projectionForm.get('id_cinema') != null) {
      this._projectionService.getHallsByCinemaId(this.projectionForm.get('id_cinema')!.value).subscribe(halls => {
        this.availableHalls = halls;
      });
    }
  }

  onSubmit() {

    if (this.projectionForm.valid) {
      const formData = this.projectionForm.value;

      this.projectionForm.get("date_time")!.value.toDate()

      this.dialogRef.close({
        dateTime: formData.date_time.toDate(),
        hallId: formData.id_hall,
        movieId: this.movieId,
        startPrice: formData.start_price
      })
    }
  }

}
