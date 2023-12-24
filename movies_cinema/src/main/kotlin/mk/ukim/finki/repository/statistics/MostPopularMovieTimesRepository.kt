package mk.ukim.finki.repository.statistics

import mk.ukim.finki.domain.statistics.MostPopularMovieTimesView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MostPopularMovieTimesRepository : JpaRepository<MostPopularMovieTimesView, Long> {

    @Query(value = """
        select * from most_popular_movie_times_view
    """, nativeQuery = true)
    fun findMostPopularMovieTimes(): List<MostPopularMovieTimesView>
}
