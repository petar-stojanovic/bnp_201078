package mk.ukim.finki.service

import mk.ukim.finki.domain.Customer
import mk.ukim.finki.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {
    fun findAll(): List<Customer> {
        return customerRepository.findAll()
    }

    fun findById(customerId: Int): Optional<Customer> {
        return customerRepository.findById(customerId.toLong())
    }

    fun createCustomer(firstName: String, lastName: String, sex: String, age: Int) {
        customerRepository.createCustomer(firstName, lastName, sex, age)
    }
}