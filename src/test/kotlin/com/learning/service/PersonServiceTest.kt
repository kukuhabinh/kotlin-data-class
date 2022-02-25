package com.learning.service

import com.learning.dto.Gender
import com.learning.dto.Person
import io.kotest.inspectors.forAll
import io.kotest.matchers.Matcher
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldHave
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.Date

class PersonServiceTest {
    val personB = Person(id = 2, name = "Bình 1", gender = Gender.FEMALE, birthDate = Date(1997, 7, 17))
    val personA = Person(id = 1, name = "Bình", gender = Gender.MALE, birthDate = Date(1999, 6, 18))
    val personC = Person(id = 3, name = "Bình 2", gender = Gender.MALE, birthDate = Date(1998, 8, 18))
    var listPerson: MutableList<Person> = mutableListOf()

    @BeforeEach
    fun setUp() {
        listPerson.add(personB)
        listPerson.add(personA)
        listPerson.add(personC)
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun `find id = 1 SHOULD BE person Person has id = 1`() {
        listPerson.findById(1)?.id shouldBe 1
    }

    @Test
    fun `find id = 4 SHOULD BE null`() {
        listPerson.findById(4)?.id shouldBe null
    }

    @Test
    fun `collect by gender male SHOULD HAVE 2 MALE person`() {
        listPerson.collectByGender(Gender.MALE).forAll { it.gender shouldBe Gender.MALE }.size shouldBe 2
    }

    @Test
    fun `collect by gender other SHOULD HAVE 0 person`() {
        listPerson.collectByGender(Gender.OTHER) shouldBe emptyList()
    }

    @Test
    fun `order by name SHOULD HAVE order PerA,PerB,perC`() {
        listPerson.sortByName() shouldBe listOf(personA, personB, personC);
    }

    @Test
    fun `order by birthDate SHOULD HAVE order PerB,perC,PerA`() {
        listPerson.sortByBirthDate() shouldBe listOf(personB, personC, personA);
    }

}