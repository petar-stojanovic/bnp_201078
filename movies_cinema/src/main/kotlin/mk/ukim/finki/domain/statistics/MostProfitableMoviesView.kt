package mk.ukim.finki.domain.statistics

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Immutable
import java.time.LocalDateTime

@Entity
@Table(name = "most_profitable_movies_view")
@Immutable
data class MostProfitableMoviesView(
    @Id
    @Column(name = "id", columnDefinition = "int")
    val id: Long,

    @Column(name = "id_movie")
    val movieId: Int,

    @Column(name = "poster")
    val poster: String,

    @Column(name = "title")
    val title: String,

    @Column(name = "total_revenue", columnDefinition = "numeric")
    val totalRevenue: Double
)