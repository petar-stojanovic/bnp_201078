package mk.ukim.finki.repository.statistics

import mk.ukim.finki.domain.statistics.MostPopularGenresView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MostPopularGenresRepository : JpaRepository<MostPopularGenresView, Long> {

    @Query(value = """
        select * from most_popular_genres_view
    """, nativeQuery = true)
    fun findMostPopularGenres(): List<MostPopularGenresView>
}
