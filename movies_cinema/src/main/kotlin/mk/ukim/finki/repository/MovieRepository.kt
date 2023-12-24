package mk.ukim.finki.repository

import jakarta.transaction.Transactional
import mk.ukim.finki.domain.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : JpaRepository<Movie, Long> {

    @Query(
        value = """
        select insert_movie(:title, :duration, :description, cast(:rating as numeric(4,2)), :specialRequirement, 
        :poster)
    """, nativeQuery = true
    )
    @Transactional
    fun save(
        title: String,
        duration: Int,
        description: String,
        rating: Double,
        specialRequirement: String?,
        poster: String
    ) : Int
}