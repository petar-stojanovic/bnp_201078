package mk.ukim.finki.repository

import mk.ukim.finki.domain.view.AllTicketsForProjectionView
import mk.ukim.finki.domain.view.MovieWithGenresView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MovieWithGenresRepository : JpaRepository<MovieWithGenresView, Long> {


    @Query(value = """
        select * from movie_with_genres_view
    """, nativeQuery = true)
    override fun findAll(): List<MovieWithGenresView>

    @Query(value = """
        select * from movie_with_genres_view
        where id_movie = :movieId
    """, nativeQuery = true)
    fun findAllByMovieId(movieId: Int): MovieWithGenresView?
}