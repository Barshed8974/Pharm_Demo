package com.example.pharmeasy_clone.Repository.CartRepo

import androidx.lifecycle.LiveData
import com.example.pharmeasy_clone.CartData.DAO
import com.example.pharmeasy_clone.CartData.DBModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyCartRepo (val dao: DAO){
    fun addTask(task: DBModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.addTask(task) }
    }

    fun getAllTasksFromTable() : LiveData<List<DBModel>> {
        return dao.getTasks()
    }
    fun editTask(task: DBModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.updateTask(task) }
    }
    fun deleteTask(task: DBModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.delete(task) }
    }
}