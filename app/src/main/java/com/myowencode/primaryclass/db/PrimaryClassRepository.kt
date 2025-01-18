package com.myowencode.primaryclass.db

import androidx.lifecycle.LiveData

class PrimaryClassRepository(private val studentDao: StudentDao) {
    val students: LiveData<List<Student>> = studentDao.list()
    
    suspend fun createStudent(student: Student) {
        studentDao.create(student)
    }

    suspend fun updateStudent(student: Student) {
        studentDao.update(student)
    }
}