package mk.ukim.finki.api

import mk.ukim.finki.domain.statistics.*
import mk.ukim.finki.repository.statistics.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/statistics")
class StatisticsController(
    val mostFrequentCustomersRepository: MostFrequentCustomersRepository,
    val mostPopularGenresRepository: MostPopularGenresRepository,
    val mostPopularMovieTimesRepository: MostPopularMovieTimesRepository,
    val mostProfitableMoviesRepository: MostProfitableMoviesRepository,
    val mostViewedMoviesRepository: MostViewedMoviesRepository,
) {


    @GetMapping("findMostFrequentCustomers")
    fun findMostFrequentCustomers(): List<MostFrequentCustomersView> {
        return mostFrequentCustomersRepository.findMostFrequentCustomers()
    }

    @GetMapping("findMostPopularGenres")
    fun findMostPopularGenres(): List<MostPopularGenresView> {
        return mostPopularGenresRepository.findMostPopularGenres()
    }

    @GetMapping("findMostPopularMovieTimes")
    fun findMostPopularMovieTimes(): List<MostPopularMovieTimesView> {
        return mostPopularMovieTimesRepository.findMostPopularMovieTimes()
    }

    @GetMapping("findMostProfitableMovies")
    fun findMostProfitableMovies(): List<MostProfitableMoviesView> {
        return mostProfitableMoviesRepository.findMostProfitableMovies()
    }

    @GetMapping("findMostViewedMovies")
    fun findMostViewedMovies(): List<MostViewedMoviesView> {
        return mostViewedMoviesRepository.findMostViewedMovies()
    }

}