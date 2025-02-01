package com.myowencode.primaryclass.db

import androidx.lifecycle.LiveData

class StudentRepository(private val studentDao: StudentDao) {
    suspend fun upsert(student: Student) {
        if (student.id == 0) {
            val id = studentDao.create(student).toInt()
            student.id = id
        } else {
            studentDao.update(student)
        }
    }

    suspend fun delete(student: Student) {
        studentDao.delete(student)
    }

    suspend fun deleteAll() {
        studentDao.deleteAll()
    }

    fun findById(id: Int): Student {
        return studentDao.findById(id)
    }
}