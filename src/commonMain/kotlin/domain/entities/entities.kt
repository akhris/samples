package domain.entities

data class Person(
    val id: String,
    val name: String,
    val surname: String,
    val middleName: String,
    val phoneNumber: String,
    val eMail: String,
    val room: String
)