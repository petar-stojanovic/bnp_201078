package mk.ukim.finki.repository

import mk.ukim.finki.domain.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : JpaRepository<Movie, Long> {
}