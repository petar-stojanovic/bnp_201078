package mk.ukim.finki.domain.view

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Immutable
import java.time.LocalDateTime

@Entity
@Table(name = "all_projections_for_movie_view")
@Immutable
data class AllProjectionsForMovieView(
    @Id
    @Column(name = "id", columnDefinition = "int")
    val id: Long,

    @Column(name = "id_movie")
    val movieId: Int,

    @Column(name = "id_projection")
    val projectionId: Int,

    @Column(name = "date_time")
    val dateTime: LocalDateTime,

    @Column(name = "hall_number")
    val hallNumber: Int,

    @Column(name = "screen_type")
    val screenType: String,

    @Column(name = "start_price", columnDefinition = "numeric(4,2)")
    val startPrice: Double,
)