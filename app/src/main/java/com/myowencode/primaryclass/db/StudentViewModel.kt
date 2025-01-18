package com.myowencode.primaryclass.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(application: Application): AndroidViewModel(application) {
    val studentList: LiveData<List<Student>>
    private val repository: PrimaryClassRepository
    
    init {
        val studentDao = PrimaryClassDatabase.getDatabase(application).getStudentDao()
        repository = PrimaryClassRepository(studentDao)
        studentList = repository.students
    }
    
    fun createStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) { 
            repository.createStudent(student)
        }
    }

    fun updateStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateStudent(student)
        }
    }
}