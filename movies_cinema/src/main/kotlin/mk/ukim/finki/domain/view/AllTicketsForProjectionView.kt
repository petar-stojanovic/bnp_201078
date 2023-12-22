package mk.ukim.finki.domain.view

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Immutable
import java.time.LocalDateTime

@Entity
@Table(name = "all_tickets_for_projection_view")
@Immutable
data class AllTicketsForProjectionView(
    @Id
    @Column(name = "id", columnDefinition = "int")
    val id: Long,

    @Column(name = "id_projection")
    val projectionId: Int,

    @Column(name = "id_ticket")
    val ticketId: Int,

    @Column(name = "projection_time")
    val projectionTime: LocalDateTime,

    @Column(name = "price", columnDefinition = "numeric(4,2)")
    val price: Double,

    @Column(name = "id_seat")
    val seatId: Int,

    @Column(name = "seat_row")
    val seatRow: Int,

    @Column(name = "seat_number")
    val seatNumber: Int,

    @Column(name = "is_bought")
    val isBought: Boolean
)