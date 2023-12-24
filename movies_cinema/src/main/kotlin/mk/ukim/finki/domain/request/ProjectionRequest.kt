package mk.ukim.finki.domain.request

import java.time.LocalDateTime

class ProjectionRequest(
    val dateTime: LocalDateTime,

    val movieId: Int,

    val hallId: Int,

    val startPrice: Double,
)