package com.example.pharmeasy_clone.view.Adapters.Interfaces

import com.example.pharmeasy_clone.Repository.Database.DataModel

interface OnCategoryClick {
    fun categoryData(category: String)
    fun detailedData(data:DataModel)
}