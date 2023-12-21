package mk.ukim.finki.domain

import jakarta.persistence.*

@Entity
@Table(name = "ticket")
data class Ticket(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    val id: Int,

    @Column(name = "price", columnDefinition = "numeric(6,2)")
    val price: Double,

    @Column(name = "payment_method", length = 100)
    val paymentMethod: String? = "",

    @ManyToOne
    @JoinColumns(
        JoinColumn(name = "id_seat", referencedColumnName = "id_seat"),
        JoinColumn(name = "id_hall", referencedColumnName = "id_hall")
    )
    val seat: Seat,

    @ManyToOne
    @JoinColumn(name = "id_projection")
    val projection: Projection,

    @ManyToOne
    @JoinColumn(name = "id_customer")
    val customer: Customer

) {

}