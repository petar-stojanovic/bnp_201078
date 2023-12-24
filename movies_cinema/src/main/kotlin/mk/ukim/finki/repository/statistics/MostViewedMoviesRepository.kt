package mk.ukim.finki.repository.statistics

import mk.ukim.finki.domain.statistics.MostViewedMoviesView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MostViewedMoviesRepository : JpaRepository<MostViewedMoviesView, Long> {

    @Query(value = """
        select * from most_viewed_movies_view
    """, nativeQuery = true)
    fun findMostViewedMovies(): List<MostViewedMoviesView>
}
