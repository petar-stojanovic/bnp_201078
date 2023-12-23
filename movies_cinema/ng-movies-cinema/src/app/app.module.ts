import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CommonModule} from "@angular/common";
import {AllMoviesComponent} from './components/all-movies/all-movies.component';
import {MovieDetailsComponent} from './components/movie-details/movie-details.component';
import {ProjectionDetailsComponent} from './components/projection-details/projection-details.component';
import {MaterialModule} from './material.module';

@NgModule({
  declarations: [
    AppComponent,
    AllMoviesComponent,
    MovieDetailsComponent,
    ProjectionDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CommonModule,
    MaterialModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
