package mk.ukim.finki.domain
import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "seat")
@IdClass(SeatId::class)
data class Seat(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seat")
    val seatId: Int,

    @Id
    @Column(name = "id_hall")
    val hallId: Int,

    @Column(name = "seat_row", nullable = false)
    val seatRow: Int,

    @Column(name = "seat_number", nullable = false)
    val seatNumber: Int
)

class SeatId(
    val seatId: Int,
    val hallId: Int
) : Serializable