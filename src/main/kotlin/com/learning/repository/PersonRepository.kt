package com.learning.repository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.learning.dto.Person
import com.learning.ultils.FileUtils

class PersonRepository {
    private val personFile:String = "person-file.json";
    private val gson = Gson();
    fun writeFile(listPerson: List<Person>) {
        val jsonString = gson.toJson(listPerson);
        FileUtils.write(personFile,jsonString);
    }
    fun readFile():List<Person>  {
        val myType = object : TypeToken<List<Person>>() {}.type
        return gson.fromJson(FileUtils.readAndTrim(personFile), myType)
    }
}