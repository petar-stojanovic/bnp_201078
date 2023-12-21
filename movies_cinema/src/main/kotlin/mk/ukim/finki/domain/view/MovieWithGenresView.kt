package mk.ukim.finki.domain.view

import jakarta.persistence.*
import org.hibernate.annotations.Immutable

@Entity
@Table(name = "movie_with_genres_view")
@Immutable
data class MovieWithGenresView(
    @Id
    @Column(name = "id", columnDefinition = "int")
    val id: Long,

    @Column(name = "id_movie")
    val movieId: Int,

    @Column(name = "title")
    val title: String,

    @Column(name = "duration")
    val duration: Int,

    @Column(name = "description")
    val description: String,

    @Column(name = "rating", columnDefinition = "numeric(4,2)")
    val rating: Double,

    @Column(name = "special_requirement")
    val specialRequirement: String?,

    @Column(name = "poster")
    val poster: String = "https://t4.ftcdn.net/jpg/04/73/25/49/360_F_473254957_bxG9yf4ly7OBO5I0O5KABlN930GwaMQz.jpg",

    @Column(name = "genre")
    val genre: String

)