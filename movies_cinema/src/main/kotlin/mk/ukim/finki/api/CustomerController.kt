package mk.ukim.finki.api

import mk.ukim.finki.domain.Customer
import mk.ukim.finki.domain.Ticket
import mk.ukim.finki.domain.view.MovieWithGenresView
import mk.ukim.finki.service.CustomerService
import mk.ukim.finki.service.MovieService
import mk.ukim.finki.service.TicketService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
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
}