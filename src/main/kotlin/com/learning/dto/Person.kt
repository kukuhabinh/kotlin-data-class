package com.learning.dto

import java.util.Date
import java.util.function.BiPredicate

enum class Gender() {
    MALE, FEMALE, OTHER
}

enum class Order() {
    DESC, ASC
}

data class Person(val id: Int, val name: String, val gender: Gender, val birthDate: Date)
