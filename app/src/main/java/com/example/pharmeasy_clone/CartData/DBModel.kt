package com.example.pharmeasy_clone.CartData

import androidx.room.ColumnInfo
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cart DB")
class DBModel (
    @ColumnInfo(name = "Description")
    var Desc: String,
    @ColumnInfo(name = "Image")
    var Image: String,
    @ColumnInfo(name = "Name")
    var Name: String,
    @ColumnInfo(name = "Price")
    var Price: String,
    @ColumnInfo(name = "Quantity")
    var qty: String,
    @ColumnInfo(name = "Total")
    var total: String
        ){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}