package mk.ukim.finki.repository

import mk.ukim.finki.domain.Movie
import org.springframework.data.jpa.repository.JpaRepository

interface MovieRepository : JpaRepository<Movie, Int> {
}