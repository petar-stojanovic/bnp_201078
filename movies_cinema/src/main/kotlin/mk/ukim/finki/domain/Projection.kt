package mk.ukim.finki.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "projection")
class Projection(

    @Id
    @Column(name = "id_projection")
    val id: Int,

    @Column(name = "date_time")
    val dateTime: LocalDateTime,

    @ManyToOne
    @JoinColumn(name = "id_movie")
    val movie: Movie,

    @ManyToOne
    @JoinColumn(name = "id_hall")
    val hall: Hall,

    @Column(name = "start_price", columnDefinition = "numeric(6,2)")
    val startPrice: Double = 10.00
)