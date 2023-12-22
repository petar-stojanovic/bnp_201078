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


    fun findAllProjections(): List<AllProjectionsForMovieView> = projectionsForMovieViewRepository
        .findAll()

    fun findAllProjectionsForMovie(movieId: Int): List<AllProjectionsForMovieView> = projectionsForMovieViewRepository
        .findAllByMovieId(movieId)

//    fun findAll(): List<MovieDTO> {
//        return movieWithGenresRepository.findAll()
//            .groupBy {
//                it.movieId
//            }.values.map {
//                convertToMovieDTO(it)
//            }
//    }
//
//    fun convertToMovieDTO(moviesList: List<MovieWithGenresView>): MovieDTO {
//        val firstMovie = moviesList.first()
//        return MovieDTO(
//            id = firstMovie.movieId,
//            title = firstMovie.title,
//            duration = firstMovie.duration,
//            description = firstMovie.description,
//            rating = firstMovie.rating,
//            specialRequirement = firstMovie.specialRequirement,
//            poster = firstMovie.poster,
//            genres = extractGenres(moviesList)
//        )
//    }
//
//    fun extractGenres(moviesList: List<MovieWithGenresView>): Set<String> =
//        moviesList.map(MovieWithGenresView::genre).toSet()
}