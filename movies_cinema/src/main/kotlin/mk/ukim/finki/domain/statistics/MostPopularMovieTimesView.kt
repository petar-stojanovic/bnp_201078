package mk.ukim.finki.domain.statistics

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Immutable
import java.sql.Time
import java.time.LocalDateTime

@Entity
@Table(name = "most_popular_movie_times_view")
@Immutable
data class MostPopularMovieTimesView(
    @Id
    @Column(name = "id", columnDefinition = "int")
    val id: Long,

    @Column(name = "projection_time")
    val projectionTime: Time,

    @Column(name = "ticket_count", columnDefinition = "int8")
    val ticketCount: Int
)