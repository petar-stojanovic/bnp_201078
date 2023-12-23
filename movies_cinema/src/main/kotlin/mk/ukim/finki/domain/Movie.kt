package mk.ukim.finki.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "movie")
data class Movie(

    @Id
    @Column(name = "id_movie")
    val id: Int,

    @Column(name = "title")
    val title: String,

    @Column(name = "duration")
    val duration: Int,

    @Column(name = "description")
    val description: String,

    @Column(name="rating", columnDefinition = "numeric(4,2)")
    val rating: Double,

    @Column(name = "special_requirement")
    val specialRequirement: String?,

    @Column(name = "poster")
    val poster: String = "https://t4.ftcdn.net/jpg/04/73/25/49/360_F_473254957_bxG9yf4ly7OBO5I0O5KABlN930GwaMQz.jpg",

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    val genres: Set<MovieGenre>
)
