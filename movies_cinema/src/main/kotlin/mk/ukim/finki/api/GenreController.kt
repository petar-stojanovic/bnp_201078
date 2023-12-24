package mk.ukim.finki.api

import mk.ukim.finki.domain.Genre
import mk.ukim.finki.service.GenreService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/genre")
class GenreController(
    val genreService: GenreService,
) {


    @GetMapping
    fun findAllGenres(): List<Genre> {
        return genreService.findAll()
    }

}