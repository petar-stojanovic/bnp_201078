package mk.ukim.finki.repository

import mk.ukim.finki.domain.view.AllProjectionsForMovieView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AllProjectionsForMovieViewRepository : JpaRepository<AllProjectionsForMovieView, Long> {

    @Query(value = """
        select * from all_projections_for_movie_view p
        where p.id_movie = :movieId and p.date_time > now()
        order by p.date_time
    """, nativeQuery = true)
    fun findAllFutureProjectionsByMovieId(movieId: Int): List<AllProjectionsForMovieView>

}