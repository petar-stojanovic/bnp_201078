package mk.ukim.finki.domain.request

class CreateCustomerRequest(
    val firstName: String,
    val lastName: String,
    val sex: String,
    val age: Int
)