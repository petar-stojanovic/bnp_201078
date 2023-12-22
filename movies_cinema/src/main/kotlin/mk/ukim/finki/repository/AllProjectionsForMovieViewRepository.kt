package mk.ukim.finki.repository

import mk.ukim.finki.domain.view.AllProjectionsForMovieView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AllProjectionsForMovieViewRepository : JpaRepository<AllProjectionsForMovieView, Long> {

    @Query(name = """
        select * from all_projections_for_movie_view
        where id_movie = :movieId
    """, nativeQuery = true)
    fun findAllByMovieId(movieId: Int): List<AllProjectionsForMovieView>
}