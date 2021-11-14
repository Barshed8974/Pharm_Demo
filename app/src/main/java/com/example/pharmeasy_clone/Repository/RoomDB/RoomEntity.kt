package com.example.pharmeasy_clone.Repository.RoomDB

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Cart")
data class RoomEntity(
    @ColumnInfo(name = "Price") val price: Int,
    @ColumnInfo(name = "Name") val name: String,
    @ColumnInfo(name = "Image") val img: String,
    @ColumnInfo(name = "Category") val category: String,
    @ColumnInfo(name = "Description") val description: String,
    @ColumnInfo(name = "Quantity") val quantity: Int
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var id: Int? = null
}
