package mk.ukim.finki.service

import mk.ukim.finki.domain.Ticket
import mk.ukim.finki.domain.view.AllProjectionsForMovieView
import mk.ukim.finki.domain.view.AllTicketsForProjectionView
import mk.ukim.finki.domain.view.MovieWithGenresView
import mk.ukim.finki.repository.AllProjectionsForMovieViewRepository
import mk.ukim.finki.repository.AllTicketsForProjectionViewRepository
import mk.ukim.finki.repository.MovieWithGenresRepository
import mk.ukim.finki.repository.TicketRepository
import org.springframework.stereotype.Service

@Service
class TicketService(
    val allTicketsForProjectionViewRepository: AllTicketsForProjectionViewRepository,
    val ticketRepository: TicketRepository,
    val customerService: CustomerService
) {

    fun findAllTickets(): List<AllTicketsForProjectionView> = allTicketsForProjectionViewRepository
        .findAll()

    fun findAllTicketsForProjection(projectionId: Int): List<AllTicketsForProjectionView> =
        allTicketsForProjectionViewRepository
            .findAllByProjectionId(projectionId)

    fun findAllTicketsByCustomer(customerId: Int): List<Ticket>? {
        val customer = customerService.findById(customerId).get()
        return ticketRepository.findAllByCustomer(customer)
    }
}