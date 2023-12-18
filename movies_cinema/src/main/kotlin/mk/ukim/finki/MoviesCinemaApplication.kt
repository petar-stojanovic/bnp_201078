package mk.ukim.finki

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MoviesCinemaApplication

fun main(args: Array<String>) {
    runApplication<MoviesCinemaApplication>(*args)
}
