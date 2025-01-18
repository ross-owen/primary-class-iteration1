package com.myowencode.primaryclass.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentDao {
    @Query("SELECT * FROM students ORDER BY firstName ASC")
    fun list(): LiveData<List<Student>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(student: Student)

    @Update
    fun update(student: Student)

    @Query("DELETE FROM students WHERE id = :id")
    fun delete(id: Int)
}