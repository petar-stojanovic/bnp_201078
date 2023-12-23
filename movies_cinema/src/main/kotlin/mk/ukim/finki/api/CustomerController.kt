package mk.ukim.finki.api

import mk.ukim.finki.domain.Customer
import mk.ukim.finki.domain.Ticket
import mk.ukim.finki.domain.request.CreateCustomerRequest
import mk.ukim.finki.domain.request.UserBuysTicketRequest
import mk.ukim.finki.domain.view.MovieWithGenresView
import mk.ukim.finki.service.CustomerService
import mk.ukim.finki.service.MovieService
import mk.ukim.finki.service.TicketService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/customer")
class CustomerController(
    val customerService: CustomerService,
) {


    @GetMapping
    fun findAllCustomers(): List<Customer> {
        return customerService.findAll()
    }

    @GetMapping(params = ["customerId"])
    fun findById(@RequestParam customerId: Int): Optional<Customer> {
        return customerService.findById(customerId)
    }

    @PostMapping
    fun customerBuysTicket(
        @RequestBody req: CreateCustomerRequest
    ) {
        customerService.createCustomer(req.firstName, req.lastName, req.sex, req.age)
    }

}