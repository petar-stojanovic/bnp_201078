package mk.ukim.finki.api

import mk.ukim.finki.domain.Movie
import mk.ukim.finki.repository.MovieRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/movie")
class MovieController (
    val movieRepository: MovieRepository
) {


    @GetMapping
    fun findAllMovies(): MutableList<Movie> {
        return movieRepository.findAll();
    }

}