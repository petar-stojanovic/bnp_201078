package mk.ukim.finki.domain

import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "movie_genre")
class MovieGenre(

    @EmbeddedId
    val id: MovieGenreId,


    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "id_movie")
    val movie: Movie,

    @ManyToOne
    @MapsId("genreId")
    @JoinColumn(name = "id_genre")
    val genre: Genre
)

@Embeddable
data class MovieGenreId(
    @Column(name = "id_movie")
    val movieId: Long,

    @Column(name = "id_genre")
    val genreId: Long
) : Serializable
