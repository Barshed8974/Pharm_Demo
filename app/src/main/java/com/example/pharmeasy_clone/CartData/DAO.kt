package com.example.pharmeasy_clone.CartData

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTask(task: DBModel)

    @Query("select * from `Cart DB`")
    fun getTasks(): LiveData<List<DBModel>>

    @Update()
    fun updateTask(task: DBModel)

    @Delete
    fun delete(task: DBModel)
}