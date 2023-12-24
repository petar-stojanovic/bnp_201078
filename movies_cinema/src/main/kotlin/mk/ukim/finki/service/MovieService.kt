package mk.ukim.finki.service

import jakarta.transaction.Transactional
import mk.ukim.finki.domain.Movie
import mk.ukim.finki.domain.view.AllProjectionsForMovieView
import mk.ukim.finki.domain.view.MovieWithGenresView
import mk.ukim.finki.repository.AllProjectionsForMovieViewRepository
import mk.ukim.finki.repository.GenreRepository
import mk.ukim.finki.repository.MovieRepository
import mk.ukim.finki.repository.MovieWithGenresRepository
import org.springframework.stereotype.Service

@Service
class MovieService(
    val movieWithGenresRepository: MovieWithGenresRepository,
    val projectionsForMovieViewRepository: AllProjectionsForMovieViewRepository,
    val movieRepository: MovieRepository,
    val genreRepository: GenreRepository
) {

    fun findAllMoviesWithGenres(): List<MovieWithGenresView> = movieWithGenresRepository.findAll()

    fun findMovieById(movieId: Int): MovieWithGenresView? = movieWithGenresRepository.findAllByMovieId(movieId)

    fun findAllProjections(): List<AllProjectionsForMovieView> = projectionsForMovieViewRepository
        .findAll()

    fun findAllProjectionsForMovie(movieId: Int): List<AllProjectionsForMovieView> = projectionsForMovieViewRepository
        .findAllFutureProjectionsByMovieId(movieId)

    @Transactional
    fun saveMovie(
        title: String,
        duration: Int,
        description: String,
        rating: Double,
        specialRequirement: String?,
        poster: String,
        genres: IntArray
    ): Movie {
        val newMovieId = movieRepository.save(title, duration, description, rating, specialRequirement, poster)

        genres.forEach {
            println("Genre - $it")
            genreRepository.addGenreToMovie(newMovieId, it)
        }

        return movieRepository.findById(newMovieId.toLong()).get();
    }
}