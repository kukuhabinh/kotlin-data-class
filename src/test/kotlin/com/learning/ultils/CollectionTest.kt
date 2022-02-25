package com.learning.ultils

import com.learning.dto.Gender
import com.learning.dto.Order
import com.learning.dto.Person
import com.learning.service.findById
import com.learning.service.sortByBirthDate
import com.learning.service.sortByName
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

class CollectionTest {
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

    @Test
    fun `find id = 4 SHOULD BE null`() {
        listPerson.findOrNull { it.id == 4 } shouldBe null;
    }

    @Test
    fun `find id = 3 SHOULD BE Person C`() {
        listPerson.findOrNull { it.id == 3 } shouldBe personC
    }

    @Test
    fun `order by name DESC SHOULD HAVE order PerA,PerB,perC`() {
        listPerson.sort(Person::name,Order.DESC) shouldBe listOf(personA, personB, personC);
    }

    @Test
    fun `order by name ASC SHOULD HAVE order personC, personB, personA`() {
        listPerson.sort(Person::name,Order.ASC) shouldBe listOf(personC, personB, personA);
    }
}