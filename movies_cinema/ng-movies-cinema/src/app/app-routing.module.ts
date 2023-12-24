import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AllMoviesComponent} from "./components/all-movies/all-movies.component";
import {MovieDetailsComponent} from "./components/movie-details/movie-details.component";
import {ProjectionDetailsComponent} from "./components/projection-details/projection-details.component";
import {CustomerComponent} from "./components/customer/customer.component";
import {AddMovieComponent} from "./components/add-movie/add-movie.component";
import {StatisticsComponent} from "./components/statistics/statistics.component";

const routes: Routes = [
  {
    path: 'movies',
    component: AllMoviesComponent
  },
  {
    path: 'movie/:movieId/projection/:projectionId',
    component: ProjectionDetailsComponent
  },
  {
    path: 'movie/:movieId',
    component: MovieDetailsComponent
  },
  {
    path: 'add',
    component: AddMovieComponent
  },
  {
    path: 'customer',
    component: CustomerComponent
  },
  {
    path: 'statistics',
    component: StatisticsComponent
  },
  {
    path: '',
    redirectTo: '/movies',
    pathMatch: 'full'
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
