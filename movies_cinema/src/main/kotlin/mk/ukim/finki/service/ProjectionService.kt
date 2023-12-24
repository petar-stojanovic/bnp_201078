package mk.ukim.finki.service

import mk.ukim.finki.domain.Hall
import mk.ukim.finki.domain.Movie
import mk.ukim.finki.repository.HallRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ProjectionService(
    val hallRepository: HallRepository
) {
    fun findHallsByCinemaId(cinemaId: Int): List<Hall> {
        return hallRepository.findAllByCinemaId(cinemaId)
    }

    fun saveProjection(dateTime: LocalDateTime, movieId: Int, hallId: Int, startPrice: Double) {
        hallRepository.save(dateTime,movieId,hallId,startPrice)
    }


}