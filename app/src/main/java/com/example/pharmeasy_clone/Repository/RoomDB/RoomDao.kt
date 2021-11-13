package com.example.pharmeasy_clone.Repository.RoomDB

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RoomDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(roomEntity: RoomEntity)

    @Update
    fun updateData(roomEntity: RoomEntity)

    @Delete
    fun deleteData(roomEntity: RoomEntity)

    @Query("select * from cart")
    fun getCartList(): LiveData<List<RoomEntity>>

    @Query("select * from cart where id=:id")
    fun getCartItem(id: Int): RoomEntity
}