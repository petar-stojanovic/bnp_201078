package mk.ukim.finki.domain.request

data class UserBuysTicketRequest(val customerId: Int, val ticketId: Int, val paymentMethod: String)