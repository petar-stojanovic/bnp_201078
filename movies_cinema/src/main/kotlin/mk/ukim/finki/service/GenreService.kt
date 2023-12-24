package mk.ukim.finki.service

import mk.ukim.finki.domain.Genre
import mk.ukim.finki.domain.view.AllProjectionsForMovieView
import mk.ukim.finki.domain.view.MovieWithGenresView
import mk.ukim.finki.repository.AllProjectionsForMovieViewRepository
import mk.ukim.finki.repository.GenreRepository
import mk.ukim.finki.repository.MovieWithGenresRepository
import org.springframework.stereotype.Service

@Service
class GenreService(
    val genreRepository: GenreRepository,
) {

    fun findAll(): List<Genre> {
        return genreRepository.findAll()
    }

}