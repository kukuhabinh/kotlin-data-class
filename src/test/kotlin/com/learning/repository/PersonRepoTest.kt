package com.learning.repository

import com.learning.dto.Gender
import com.learning.dto.Person
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

class PersonRepoTest {
    val personB = Person(id = 2, name = "Bình 1", gender = Gender.FEMALE, birthDate = Date(1997, 7, 17));
    val personA = Person(id = 1, name = "Bình", gender = Gender.MALE, birthDate = Date(1999, 6, 18));
    val personC = Person(id = 3, name = "Bình 2", gender = Gender.MALE, birthDate = Date(1998, 8, 18));
    var listPerson: MutableList<Person> = mutableListOf();
    val personRepository = PersonRepository();
    @BeforeEach
    fun setUp() {
        listPerson.add(personB);
        listPerson.add(personA);
        listPerson.add(personC);
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun `write listPerson to file`() {
        personRepository.writeFile(listPerson);
    }
    @Test
    fun `read person file SHOULD BE listPerson`() {
        personRepository.readFile() shouldBe listPerson;
    }
}