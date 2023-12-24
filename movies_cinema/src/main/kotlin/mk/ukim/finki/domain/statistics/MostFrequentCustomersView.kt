package mk.ukim.finki.domain.statistics

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Immutable
import java.time.LocalDateTime

@Entity
@Table(name = "most_frequent_customers_view")
@Immutable
data class MostFrequentCustomersView(
    @Id
    @Column(name = "id", columnDefinition = "int")
    val id: Long,

    @Column(name = "id_customer")
    val movieId: Int,

    @Column(name = "first_name")
    val firstName: String,

    @Column(name = "last_name")
    val lastName: String,

    @Column(name = "ticket_count", columnDefinition = "int8")
    val ticketCount: Int
)