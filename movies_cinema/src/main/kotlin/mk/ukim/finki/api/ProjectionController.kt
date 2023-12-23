package mk.ukim.finki.api

import mk.ukim.finki.domain.view.AllProjectionsForMovieView
import mk.ukim.finki.service.MovieService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/projection")
class ProjectionController (
    val movieService: MovieService
) {
    @GetMapping
    fun findAllProjections(@RequestParam(required = false) movieId: Int?): List<AllProjectionsForMovieView> {
        return if (movieId == null) {
            movieService.findAllProjections()
        } else {
            movieService.findAllProjectionsForMovie(movieId)
        }
    }
}