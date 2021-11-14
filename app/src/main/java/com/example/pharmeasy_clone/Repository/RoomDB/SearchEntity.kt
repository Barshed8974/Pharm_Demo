package com.example.pharmeasy_clone.Repository.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Search Data")
data class SearchEntity(
    @PrimaryKey
    @ColumnInfo(name = "Search") val search: String
)