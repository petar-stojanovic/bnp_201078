package mk.ukim.finki.domain

import jakarta.persistence.*

@Entity
@Table(name = "customer")
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    val id: Long = 0,

    @Column(name = "first_name")
    val firstName: String,

    @Column(name = "last_name")
    val lastName: String,

    @Column(name = "sex")
    val sex: String,

    @Column(name = "age")
    val age: Int
)