package mk.ukim.finki.domain.view

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Immutable
import java.time.LocalDateTime

@Entity
@Table(name = "all_tickets_by_user_view")
@Immutable
data class AllTicketsByUserView(
    @Id
    @Column(name = "id", columnDefinition = "int")
    val id: Long,

    @Column(name = "id_customer")
    val customerId: Int,

    @Column(name = "date_time")
    val dateTime: LocalDateTime,

    @Column(name = "poster")
    val poster: String,

    @Column(name = "movie_title")
    val movieTitle: String,

    @Column(name = "special_requirement")
    val specialRequirement: String,

    @Column(name = "ticket_price", columnDefinition = "numeric(4,2)")
    val ticketPrice: Double,

    @Column(name = "payment_method")
    val paymentMethod: String,

    @Column(name = "row_number")
    val rowNumber: Int,

    @Column(name = "col_number")
    val colNumber: Int,

    @Column(name = "screen_type")
    val screenType: String,

    @Column(name = "cinema_name")
    val cinemaName: String
)