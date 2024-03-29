package mk.ukim.finki.repository

import jakarta.transaction.Transactional
import mk.ukim.finki.domain.Ticket
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TicketRepository : JpaRepository<Ticket, Long> {


    @Transactional
    @Query(value = """
        select customer_buys_ticket(:customerId, :ticketId, :paymentMethod)
    """, nativeQuery = true)
    fun customerBuysTicket(customerId: Int, ticketId: Int, paymentMethod: String)

}