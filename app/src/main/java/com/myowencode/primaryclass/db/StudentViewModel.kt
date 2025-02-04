package com.myowencode.primaryclass.db

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Date

class StudentViewModel(application: Application) : AndroidViewModel(application) {
    private val logName: String = "KotlinDemo"

    private val repository: StudentRepository
    private val dao = PrimaryClassDatabase.getDatabase(application).getStudentDao()

    init {
        repository = StudentRepository(dao)
    }

    fun upsert(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.upsert(student)
        }
    }

    fun delete(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(student)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }

    fun findById(id: Int): Student? {
        var student: Student? = null
        viewModelScope.launch(Dispatchers.IO) {
            student = repository.findById(id)
        }
        return student
    }


    // **************************************************
    // This stuff is temporary just for the module 1 demo
    // **************************************************
    fun demoDatabase() {
        viewModelScope.launch(Dispatchers.IO) {
            // delete everything to start
            dao.deleteAll()

            // list all students - should be empty
            logStudents(dao.getAll())

            // create a student
            var student = createStudent("Ross", "Owen", PrimaryClassDatabase.GENDER_MALE, 1, 19)
            Log.d(logName, "Student created. New id is ${student.id}")

            // find the student just created
            student = dao.findById(student.id)
            Log.d(logName, "Found student: ${student.getFullName()}")

            // create another student
            student = createStudent("Lisa", "Masters", PrimaryClassDatabase.GENDER_FEMALE, 10, 3)
            Log.d(logName, "Student created. New id is ${student.id}")

            // create another student
            student = createStudent("Tyrell", "Owen", PrimaryClassDatabase.GENDER_MALE, 8, 5)
            Log.d(logName, "Student created. New id is ${student.id}")

            // list the students - should contain 3
            logStudents(dao.getAll())
        }
    }

    private suspend fun createStudent(
        firstName: String,
        lastName: String,
        gender: String,
        month: Int,
        day: Int
    ): Student {
        val birthday = Calendar.getInstance()
        birthday.set(2000, month, day)
        val student = Student(
            0,
            firstName,
            lastName,
            gender,
            Date(birthday.timeInMillis)
        )
        student.id = dao.create(student).toInt()
        return student
    }

    private fun logStudents(students: List<Student>) {
        Log.d(logName, "STUDENT LIST")
        Log.d(logName, "------------")
        students.forEach { student ->
            Log.d(logName, student.getFullName())
        }
        Log.d(logName, "============")
    }
}