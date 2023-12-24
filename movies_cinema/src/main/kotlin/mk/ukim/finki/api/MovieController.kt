package mk.ukim.finki.api

import mk.ukim.finki.domain.Movie
import mk.ukim.finki.domain.request.CreateCustomerRequest
import mk.ukim.finki.domain.request.MovieRequest
import mk.ukim.finki.domain.view.MovieWithGenresView
import mk.ukim.finki.service.MovieService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/movie")
class MovieController(
    val movieService: MovieService,
) {


    @GetMapping
    fun findAllMovies(): List<MovieWithGenresView> {
        return movieService.findAllMoviesWithGenres()
    }

    @GetMapping(params = ["movieId"])
    fun findMovieById(@RequestParam movieId: Int): MovieWithGenresView? {
        return movieService.findMovieById(movieId)
    }


    @PostMapping
    fun saveMovie(
        @RequestBody req: MovieRequest
    ): Movie {
        return movieService.saveMovie(
            req.title, req.duration, req.description, req.rating,
            req.specialRequirement, req.poster, req.genres
        )
    }
}