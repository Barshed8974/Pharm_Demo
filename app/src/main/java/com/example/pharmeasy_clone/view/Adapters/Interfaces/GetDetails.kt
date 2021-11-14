package com.example.pharmeasy_clone.view.Adapters.Interfaces

import com.example.pharmeasy_clone.Repository.Database.DataModel

interface GetDetails {
    fun getDetailedView(data: DataModel)
}