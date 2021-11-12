package com.example.pharmeasy_clone.Repository.Database

import com.example.pharmeasy_clone.R

class CreatingData {
    private var list = mutableListOf<DataModel>()

    fun buildData(): List<DataModel> {
        val data =
            DataModel(90, "Dettol", R.drawable.img, "Dettol", "short description", "Description","Benefits", "Uses")
        for (i in 0..40) {
            list.add(data)
        }
        return list
    }

    fun buildCategory(): List<CategoryModel> {
        val list = mutableListOf<CategoryModel>()
        list.add(CategoryModel(R.drawable.img, "Covid Essentials"))
        list.add(CategoryModel(R.drawable.img, "Devices"))
        list.add(CategoryModel(R.drawable.img, "Nutrition & Fitness Supplements"))
        list.add(CategoryModel(R.drawable.img, "Personal Care"))
        list.add(CategoryModel(R.drawable.img, "Ayurvedic Care"))
        list.add(CategoryModel(R.drawable.img, "Baby & Mom Care"))
        list.add(CategoryModel(R.drawable.img, "Skin Care"))
        list.add(CategoryModel(R.drawable.img, "Diabetic Care"))
        list.add(CategoryModel(R.drawable.img, "Sexual Wellness"))
        list.add(CategoryModel(R.drawable.img, "Short Term Ailments"))
        list.add(CategoryModel(R.drawable.img, "Lifestyle Ailments"))
        list.add(CategoryModel(R.drawable.img, "Home Care"))
        list.add(CategoryModel(R.drawable.img, "Women Care"))
        list.add(CategoryModel(R.drawable.img, "Health Food and Drinks"))
        list.add(CategoryModel(R.drawable.img, "Ortho Care"))
        list.add(CategoryModel(R.drawable.img, "Pet Care"))
        return list
    }
}