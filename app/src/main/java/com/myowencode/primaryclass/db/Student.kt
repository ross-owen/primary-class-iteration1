package com.myowencode.primaryclass.db

import android.annotation.SuppressLint
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Date

@Entity(tableName = "students")
data class Student(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var firstName: String,
    var lastName: String,
    var gender: String = PrimaryClassDatabase.GENDER_MALE,
    var birthDate: Date?

) {
    fun isMale(): Boolean {
        return gender.equals(PrimaryClassDatabase.GENDER_MALE)
    }

    fun getFullName(): String {
        var full = firstName
        if (lastName != null && lastName!!.isNotEmpty()) {
            full += " $lastName"
        }
        return full
    }
    
    @SuppressLint("SimpleDateFormat")
    fun getBirthday(): String {
        var bday = ""
        if (birthDate != null) {
            bday = SimpleDateFormat("MMM dd").format(birthDate!!)
        }
        return bday
    }
}