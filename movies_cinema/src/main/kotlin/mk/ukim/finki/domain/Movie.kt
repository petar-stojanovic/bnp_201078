package mk.ukim.finki.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "movie")
data class Movie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    val id: Int,


    val title: String,
    val duration: Int,
    val description: String,
    val rating: Double,
    val specialRequirement: String,
    val poster: String,


    ) {

}
