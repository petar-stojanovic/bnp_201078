package mk.ukim.finki.service

import mk.ukim.finki.domain.Movie
import mk.ukim.finki.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieService(
    val movieRepository: MovieRepository
) {

    fun findAll(): List<Movie> = movieRepository.findAll();
}