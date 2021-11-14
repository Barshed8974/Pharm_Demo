package com.example.pharmeasy_clone.ViewModel.Firebase

import androidx.lifecycle.ViewModel
import com.example.myapplication.Repo.FirebaseCallback
import com.example.myapplication.Repo.ProductsRepository

class getData (
    private val repository: ProductsRepository = ProductsRepository()
): ViewModel() {
    fun getResponseUsingCallback(callback: FirebaseCallback) {
        repository.getResponseFromRealtimeDatabaseUsingCallback(callback)
    }
}