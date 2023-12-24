package mk.ukim.finki.domain.statistics

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Immutable
import java.time.LocalDateTime

@Entity
@Table(name = "most_popular_genres_view")
@Immutable
data class MostPopularGenresView(
    @Id
    @Column(name = "id", columnDefinition = "int")
    val id: Long,

    @Column(name = "name")
    val name: String,

    @Column(name = "ticket_count", columnDefinition = "int8")
    val ticketCount: Int
)