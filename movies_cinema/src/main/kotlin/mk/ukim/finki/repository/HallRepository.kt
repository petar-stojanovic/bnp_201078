package mk.ukim.finki.repository

import jakarta.transaction.Transactional
import mk.ukim.finki.domain.Hall
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface HallRepository : JpaRepository<Hall, Long> {

    @Query(
        value = """
        select * from hall where id_cinema = :cinemaId
    """, nativeQuery = true
    )
    fun findAllByCinemaId(cinemaId: Int): List<Hall>

    @Query(
        value = """
        select insert_projection(:dateTime, :movieId, :hallId, cast(:startPrice as numeric(4,2)))
    """, nativeQuery = true
    )
    @Transactional
    fun save(dateTime: LocalDateTime, movieId: Int, hallId: Int, startPrice: Double)
}