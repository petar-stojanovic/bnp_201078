package mk.ukim.finki.domain

import jakarta.persistence.*


@Entity
@Table(name = "hall")
class Hall(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hall")
    val id: Int,

    @Column(name = "hall_number")
    val hallNumber: Int,

    @Column(name = "screen_type")
    val screenType: String,

    @ManyToOne
    @JoinColumn(name = "id_cinema")
    val cinema: Cinema
)
