package domain.repository

import domain.entities.Person
import kotlinx.coroutines.delay

class TestPersonsRepository : IPersonsRepository {
    override suspend fun getAllPersons(): List<Person> {
        delay(500L)
        return listOf(
            Person("person1","Антон", "Иванов", "Павлович", "1414", "ivanov@mail.ru", "213"),
            Person("person2","Анатолий", "Петров", "Григорьевич", "1213", "petrov@mail.ru", "423"),
            Person("person3","Андрей", "Сидоров", "Николаевич", "4523", "sidorov@mail.ru", "523"),
            Person("person4","Михаил", "Углов", "Викторович", "7875", "uglov@mail.ru", "634"),
            Person("person5","Екатерина", "Васильева", "Юрьевна", "3242", "vasilieva@mail.ru", "234"),
        )
    }
}