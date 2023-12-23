package mk.ukim.finki.repository

import mk.ukim.finki.domain.view.AllTicketsByUserView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AllTicketsByUserViewRepository : JpaRepository<AllTicketsByUserView, Long> {

    @Query(value = """
        select * from all_tickets_by_user_view where id_customer = :customerId
    """,nativeQuery = true)
    fun findAllByCustomer(customerId: Int): List<AllTicketsByUserView>
}