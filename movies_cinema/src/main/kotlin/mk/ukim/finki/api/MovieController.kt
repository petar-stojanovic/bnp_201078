package mk.ukim.finki.api

import mk.ukim.finki.domain.Movie
import mk.ukim.finki.domain.MovieDTO
import mk.ukim.finki.domain.view.MovieWithGenresView
import mk.ukim.finki.repository.MovieRepository
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
    fun findAllMovies(): List<MovieDTO> {
        return movieService.findAll()
    }


    @GetMapping("all")
    fun findAllMoviesWithGenres(): List<MovieWithGenresView> {
        return movieWithGenresRepository.findAll()
    }

}