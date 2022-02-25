package com.learning.service

import com.learning.dto.Gender
import com.learning.dto.Person
import com.learning.ultils.findOrNull
import com.learning.ultils.sort

fun List<Person>.findById(id: Int): Person? = this.findOrNull { it.id == id }

fun List<Person>.collectByGender(gender: Gender): List<Person> = this.filter { it.gender == gender }

fun List<Person>.sortByName(): List<Person> = this.sort(Person::name)

fun List<Person>.sortByBirthDate(): List<Person> = this.sort(Person::birthDate)
