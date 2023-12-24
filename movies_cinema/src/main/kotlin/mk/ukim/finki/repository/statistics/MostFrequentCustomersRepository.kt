package mk.ukim.finki.repository.statistics

import mk.ukim.finki.domain.statistics.MostFrequentCustomersView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MostFrequentCustomersRepository : JpaRepository<MostFrequentCustomersView, Long> {

    @Query(value = """
        select * from most_frequent_customers_view
    """, nativeQuery = true)
    fun findMostFrequentCustomers(): List<MostFrequentCustomersView>
}
