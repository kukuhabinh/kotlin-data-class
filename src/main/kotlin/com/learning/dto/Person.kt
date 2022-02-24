package com.learning.dto
import java.util.Date

enum class Gender(){
    MALE,FEMALE,OTHER
}

data class Person (val id:Int,val name:String,val gender:Gender,val birthDate: Date)
