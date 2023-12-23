import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AllMoviesComponent} from "./components/all-movies/all-movies.component";
import {MovieDetailsComponent} from "./components/movie-details/movie-details.component";
import {ProjectionDetailsComponent} from "./components/projection-details/projection-details.component";

const routes: Routes = [
  {
    path: '/movies',
    component: AllMoviesComponent
  },
  {
    path: 'movies/:movieId',
    component: MovieDetailsComponent
  },
  {
    path: 'projections/:projectionId',
    component: ProjectionDetailsComponent
  },
  {
    path: '',
    redirectTo: '/movies',
    pathMatch: 'full'
  }
  // Add more routes as needed
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
