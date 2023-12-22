package mk.ukim.finki.repository

import mk.ukim.finki.domain.view.AllTicketsForProjectionView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AllTicketsForProjectionViewRepository : JpaRepository<AllTicketsForProjectionView, Long> {

    @Query(name = """
        select * from all_tickets_for_projection_view
        where id_projection = :projectionId
    """, nativeQuery = true)
    fun findAllByProjectionId(projectionId: Int): List<AllTicketsForProjectionView>
}