package mk.ukim.finki.service

import mk.ukim.finki.domain.view.AllTicketsByUserView
import mk.ukim.finki.domain.view.AllTicketsForProjectionView
import mk.ukim.finki.repository.*
import org.springframework.stereotype.Service

@Service
class TicketService(
    val allTicketsForProjectionViewRepository: AllTicketsForProjectionViewRepository,
    val allTicketsByUserView: AllTicketsByUserViewRepository,
    val ticketRepository: TicketRepository,
    val customerService: CustomerService
) {

    fun findAllTickets(): List<AllTicketsForProjectionView> = allTicketsForProjectionViewRepository
        .findAll()

    fun findAllTicketsForProjection(projectionId: Int): List<AllTicketsForProjectionView> =
        allTicketsForProjectionViewRepository
            .findAllByProjectionId(projectionId)

    fun findAllTicketsByCustomer(customerId: Int): List<AllTicketsByUserView>? {
        val customer = customerService.findById(customerId).get()
        return allTicketsByUserView.findAllByCustomer(customer.id)
    }

    fun customerBuysTicket(customerId: Int, ticketId: Int, paymentMethod: String) {
        ticketRepository.customerBuysTicket(customerId, ticketId, paymentMethod);
    }

}