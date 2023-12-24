package mk.ukim.finki.repository

import jakarta.transaction.Transactional
import mk.ukim.finki.domain.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<Customer, Long> {

    @Query(value = """
        select insert_customer(:firstName, :lastName, :sex, :age)
    """,nativeQuery = true)
    @Transactional
    fun createCustomer(firstName: String, lastName: String, sex: String, age: Int)
}