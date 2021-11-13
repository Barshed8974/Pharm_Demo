package com.example.pharmeasy_clone.view.Adapters.Interfaces

import com.example.pharmeasy_clone.Repository.RoomDB.RoomEntity

interface CartOnClick {
    fun onDelete(roomEntity: RoomEntity)
    fun onClick(roomEntity: RoomEntity)
}