package mk.ukim.finki.api

import mk.ukim.finki.domain.view.AllTicketsForProjectionView
import mk.ukim.finki.service.MovieService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/ticket")
class TicketsController(
    val movieService: MovieService
) {


    @GetMapping
    fun findAllTickets(@RequestParam(required = false) projectionId: Int?): List<AllTicketsForProjectionView> {
        return if (projectionId == null) {
            movieService.findAllTickets()
        } else {
            movieService.findAllTicketsForProjection(projectionId)
        }
    }
}