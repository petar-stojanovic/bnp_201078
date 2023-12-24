package mk.ukim.finki.repository.statistics

import mk.ukim.finki.domain.statistics.MostProfitableMoviesView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MostProfitableMoviesRepository : JpaRepository<MostProfitableMoviesView, Long> {

    @Query(
        value = """
        select * from most_profitable_movies_view
    """, nativeQuery = true
    )
    fun findMostProfitableMovies(): List<MostProfitableMoviesView>
}
