import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AllMoviesComponent} from "./components/all-movies/all-movies.component";
import {MovieDetailsComponent} from "./components/movie-details/movie-details.component";
import {ProjectionDetailsComponent} from "./components/projection-details/projection-details.component";

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
