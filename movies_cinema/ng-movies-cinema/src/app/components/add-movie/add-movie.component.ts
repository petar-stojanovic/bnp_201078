import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {GenreService} from "../../services/genre.service";
import {Observable} from "rxjs";
import {MovieService} from "../../services/movie.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent implements OnInit {
  movieForm: FormGroup;
  availableGenres: { id: number, name: string }[] | null = null;

  constructor(private fb: FormBuilder,
              private router: Router,
              private _genreService: GenreService,
              private _movieService: MovieService
  ) {
    this.movieForm = this.fb.group({
      title: ['', Validators.required],
      duration: ['', Validators.required],
      description: ['', Validators.required],
      rating: ['', [Validators.required, Validators.min(1), Validators.max(10)]],
      specialRequirement: ['PG'],
      poster: ['', Validators.required],
      genres: [[], Validators.required]
    });
  }

  ngOnInit() {
    this._genreService.getAllGenres().subscribe(it => {
      console.log(it)
      this.availableGenres = it
    })
  }

  onSubmit() {
    if (this.movieForm.valid) {
      const formData = this.movieForm.value;
      console.log(formData);
      console.log(formData.genres);
      this._movieService.saveMovie(formData).subscribe(_ => {
        this.router.navigate([""])
      })
    }
  }

}
