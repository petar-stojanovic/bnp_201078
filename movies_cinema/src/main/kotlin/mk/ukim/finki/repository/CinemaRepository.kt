package mk.ukim.finki.repository

import mk.ukim.finki.domain.Cinema
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CinemaRepository : JpaRepository<Cinema, Long> {
}