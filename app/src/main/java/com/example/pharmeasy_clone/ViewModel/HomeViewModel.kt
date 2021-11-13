package com.example.pharmeasy_clone.view

import androidx.lifecycle.ViewModel
import com.example.pharmeasy_clone.Repository.Database.CategoryModel
import com.example.pharmeasy_clone.Repository.Database.CreatingData
import com.example.pharmeasy_clone.Repository.Database.DataModel
import retrofit2.Call
import retrofit2.Callback


class HomeViewModel : ViewModel() {


    fun fetchApi(): List<MedicalItem?> {
        var list: List<MedicalItem?> = ArrayList()
        val fetchAPI = Network.getRetrofitInstance().create(getAPI::class.java)
        fetchAPI.getData().enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if (response.body() != null) {
                    list = response.body()!!.medical!!
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {

            }
        })
        return list!!
    }

    fun getDetailedList(): List<DataModel> {
        return CreatingData().buildData()
    }

    fun getCategory(): List<CategoryModel> {
        return CreatingData().buildCategory()
    }



}