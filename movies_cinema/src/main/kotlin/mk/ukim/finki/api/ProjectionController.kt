package mk.ukim.finki.api

import mk.ukim.finki.domain.view.AllProjectionsForMovieView
import mk.ukim.finki.repository.AllProjectionsForMovieViewRepository
import mk.ukim.finki.service.MovieService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/projection")
class ProjectionController (
    val movieService: MovieService
) {


    @GetMapping
    fun findAllProjections(): List<AllProjectionsForMovieView> {
        return movieService.findAllProjections()
    }
    @GetMapping("/{movieId}")
    fun findAllProjectionForMovies(@PathVariable movieId: Int): List<AllProjectionsForMovieView> {
        return movieService.findAllProjectionsForMovie(movieId)
    }

}