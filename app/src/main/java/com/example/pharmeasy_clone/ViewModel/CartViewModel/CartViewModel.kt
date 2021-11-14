package com.example.pharmeasy_clone.ViewModel.CartViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pharmeasy_clone.CartData.DBModel
import com.example.pharmeasy_clone.Repository.CartRepo.MyCartRepo

class CartViewModel (val repository: MyCartRepo) : ViewModel() {

    fun createTask(task :DBModel)
    {
        repository.addTask(task)
    }
    fun getAllTask(): LiveData<List<DBModel>>
    {
        return repository.getAllTasksFromTable()
    }
    fun editTask(task: DBModel)
    {
        repository.editTask(task)
    }

    fun deleteTask(task: DBModel)
    {
        repository.deleteTask(task)
    }
}