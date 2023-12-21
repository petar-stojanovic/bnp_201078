package mk.ukim.finki.domain

data class MovieDTO(
    val id: Int,

    val title: String,

    val duration: Int,

    val description: String,

    val rating: Double,

    val specialRequirement: String?,

    val poster: String,

    val genres: Set<String> = setOf()
){
}