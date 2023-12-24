package mk.ukim.finki.repository

import jakarta.transaction.Transactional
import mk.ukim.finki.domain.Genre
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface GenreRepository : JpaRepository<Genre, Long> {
    @Query(
        value = """
        select insert_movie_genre(:movieId, :genreId)
    """, nativeQuery = true
    )
    @Transactional
    fun addGenreToMovie(movieId: Int, genreId: Int)

}