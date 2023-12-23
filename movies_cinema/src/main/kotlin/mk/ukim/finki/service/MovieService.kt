package mk.ukim.finki.service

import mk.ukim.finki.domain.view.AllProjectionsForMovieView
import mk.ukim.finki.domain.view.MovieWithGenresView
import mk.ukim.finki.repository.AllProjectionsForMovieViewRepository
import mk.ukim.finki.repository.MovieWithGenresRepository
import org.springframework.stereotype.Service

@Service
class MovieService(
    val movieWithGenresRepository: MovieWithGenresRepository,
    val projectionsForMovieViewRepository: AllProjectionsForMovieViewRepository
) {

    fun findAllMoviesWithGenres(): List<MovieWithGenresView> = movieWithGenresRepository.findAll()

    fun findMovieById(movieId: Int): MovieWithGenresView? = movieWithGenresRepository.findAllByMovieId(movieId)

    fun findAllProjections(): List<AllProjectionsForMovieView> = projectionsForMovieViewRepository
        .findAll()

    fun findAllProjectionsForMovie(movieId: Int): List<AllProjectionsForMovieView> = projectionsForMovieViewRepository
        .findAllFutureProjectionsByMovieId(movieId)
}