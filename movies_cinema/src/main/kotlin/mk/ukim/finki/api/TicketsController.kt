package mk.ukim.finki.api

import mk.ukim.finki.domain.request.UserBuysTicketRequest
import mk.ukim.finki.domain.view.AllTicketsByUserView
import mk.ukim.finki.domain.view.AllTicketsForProjectionView
import mk.ukim.finki.service.TicketService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/ticket")
class TicketsController(
    val ticketService: TicketService
) {


    @GetMapping
    fun findAllTickets(@RequestParam(required = false) projectionId: Int?): List<AllTicketsForProjectionView> {
        return if (projectionId == null) {
            ticketService.findAllTickets()
        } else {
            ticketService.findAllTicketsForProjection(projectionId)
        }
    }

    @GetMapping(params = ["customerId"])
    fun findAllTicketsByCustomer(@RequestParam customerId: Int): List<AllTicketsByUserView>? {
        return ticketService.findAllTicketsByCustomer(customerId)
    }

    @PostMapping
    fun customerBuysTicket(
        @RequestBody req: UserBuysTicketRequest
    ) {
        ticketService.customerBuysTicket(req.customerId, req.ticketId, req.paymentMethod)
    }
}