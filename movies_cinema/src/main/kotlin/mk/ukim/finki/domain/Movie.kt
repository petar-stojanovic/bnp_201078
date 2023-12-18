package mk.ukim.finki.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "movie")
data class Movie(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    val id: Long,

    @Column(name = "title")
    val title: String,

    @Column(name = "duration")
    val duration: Int,

    @Column(name = "description")
    val description: String,

    @Column
    val rating: Double,

    @Column(name = "special_requirement", length = 255)
    val specialRequirement: String?,

    @Column(name = "poster")
    val poster: String = "https://t4.ftcdn.net/jpg/04/73/25/49/360_F_473254957_bxG9yf4ly7OBO5I0O5KABlN930GwaMQz.jpg",

    @OneToMany(mappedBy = "movie")
    val genres: Set<MovieGenre>
)
