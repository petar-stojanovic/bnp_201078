package mk.ukim.finki.domain.request

class MovieRequest(
    val title: String,

    val duration: Int,

    val description: String,

    val rating: Double,

    val specialRequirement: String?,

    val poster: String = "https://t4.ftcdn.net/jpg/04/73/25/49/360_F_473254957_bxG9yf4ly7OBO5I0O5KABlN930GwaMQz.jpg",

    val genres: IntArray
)