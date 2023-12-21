package mk.ukim.finki.domain

import jakarta.persistence.*

@Entity
@Table(name = "genre")
data class Genre(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genre")
    val id: Int,

    @Column(name = "name")
    val name: String,

    @ManyToOne
    @JoinColumn(name = "id_supgenre")
    val supGenre: Genre? = null,

    @OneToMany(mappedBy = "genre")
    val movies: Set<MovieGenre>
)