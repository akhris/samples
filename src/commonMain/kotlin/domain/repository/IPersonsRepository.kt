package domain.repository

import domain.entities.Person

interface IPersonsRepository {
    suspend fun getAllPersons(): List<Person>
}