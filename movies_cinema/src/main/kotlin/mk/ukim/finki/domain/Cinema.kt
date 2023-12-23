package mk.ukim.finki.domain

import jakarta.persistence.*

@Entity
@Table(name = "cinema")
data class Cinema(

    @Id
    @Column(name = "id_cinema")
    val id: Int,

    @Column
    val name: String,

    @Column
    val address: String,

    @Column
    val city: String,

    @Column
    val country: String
) {

}