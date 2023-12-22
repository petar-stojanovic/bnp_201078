package mk.ukim.finki.api

import mk.ukim.finki.domain.view.MovieWithGenresView
import mk.ukim.finki.repository.MovieWithGenresRepository
import mk.ukim.finki.service.MovieService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/movie")
class MovieController (
    val movieService: MovieService,
    val movieWithGenresRepository: MovieWithGenresRepository
) {


    @GetMapping
    fun findAllMovies(): List<MovieWithGenresView> {
        return movieService.findAllMoviesWithGenres()
    }

}