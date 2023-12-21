package mk.ukim.finki.repository

import mk.ukim.finki.domain.Movie
import mk.ukim.finki.domain.view.MovieWithGenresView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieWithGenresRepository : JpaRepository<MovieWithGenresView, Int> {
}