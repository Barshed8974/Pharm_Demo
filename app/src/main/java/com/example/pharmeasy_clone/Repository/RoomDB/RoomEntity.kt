package com.example.pharmeasy_clone.Repository.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pharmeasy_clone.Repository.Database.DataModel

@Entity(tableName = "Cart")
data class RoomEntity(
    @ColumnInfo(name = "Price")
    val price: Int,
    @ColumnInfo(name = "Name")
    val name: String,
    @ColumnInfo(name = "Image")
    val img: Int,
    @ColumnInfo(name = "Category")
    val category: String,
    @ColumnInfo(name = "Short Description")
    val shortDescription: String,
    @ColumnInfo(name = "Description")
    val description: String,
    @ColumnInfo(name = "Key Benefits")
    val keyBenefits: String,
    @ColumnInfo(name = "Uses")
    val uses: String,
    @ColumnInfo(name = "Quantity")
    val quantity: Int,
    @ColumnInfo(name="Data Model")
    val dataModel: DataModel
) {
    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}