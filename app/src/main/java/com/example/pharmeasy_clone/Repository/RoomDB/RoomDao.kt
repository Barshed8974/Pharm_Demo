package com.example.pharmeasy_clone.Repository.RoomDB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pharmeasy_clone.view.Activities.SearchActivity

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


    @Query("select * from `search data`")
    fun getSearchList(): LiveData<List<SearchEntity>>

    @Delete
    fun deleteSearch(searchEntity: SearchEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(searchEntity: SearchEntity)
}