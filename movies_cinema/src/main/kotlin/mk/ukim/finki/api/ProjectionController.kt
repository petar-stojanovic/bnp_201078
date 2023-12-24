package mk.ukim.finki.api

import mk.ukim.finki.domain.Cinema
import mk.ukim.finki.domain.Hall
import mk.ukim.finki.domain.Movie
import mk.ukim.finki.domain.request.MovieRequest
import mk.ukim.finki.domain.request.ProjectionRequest
import mk.ukim.finki.domain.view.AllProjectionsForMovieView
import mk.ukim.finki.domain.view.MovieWithGenresView
import mk.ukim.finki.repository.CinemaRepository
import mk.ukim.finki.service.MovieService
import mk.ukim.finki.service.ProjectionService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/projection")
class ProjectionController(
    val movieService: MovieService,
    val projectionService: ProjectionService,
    val cinemaRepository: CinemaRepository
) {
    @GetMapping
    fun findAllProjections(@RequestParam(required = false) movieId: Int?): List<AllProjectionsForMovieView> {
        return if (movieId == null) {
            movieService.findAllProjections()
        } else {
            movieService.findAllProjectionsForMovie(movieId)
        }
    }

    @GetMapping(path = ["halls"], params = ["cinemaId"])
    fun findHallsByCinemaId(@RequestParam cinemaId: Int): List<Hall> {
        return projectionService.findHallsByCinemaId(cinemaId)
    }

    @PostMapping
    fun saveMovie(
        @RequestBody req: ProjectionRequest
    ) {
        return projectionService.saveProjection(
            req.dateTime, req.movieId, req.hallId, req.startPrice
        )
    }


    @GetMapping("cinemas")
    fun findAllCinemas(): List<Cinema> {
        return cinemaRepository.findAll()
    }

}