package com.example.pharmeasy_clone.Repository.Database

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataModel(
    val price: Int,
    val name: String,
    val img: String,
    val category: String,
    val description: String,
    ): Parcelable


