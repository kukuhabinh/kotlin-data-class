package com.learning.service

import com.learning.dto.Gender
import com.learning.dto.Person

fun List<Person>.findById(id: Int): Person? = this.firstOrNull { it.id == id }

fun List<Person>.collectByGender(gender: Gender): List<Person> = this.filter { it.gender == gender }

fun List<Person>.sortByName(): List<Person> = this.sortedBy { it.name }

fun List<Person>.sortByBirthDate(): List<Person> = this.sortedBy { it.birthDate }

