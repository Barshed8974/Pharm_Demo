package com.example.pharmeasy_clone.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.disklrucache.DiskLruCache
import com.example.pharmeasy_clone.Repository.RoomDB.RoomDao
import com.example.pharmeasy_clone.Repository.RoomDB.RoomDatabaseModel
import com.example.pharmeasy_clone.Repository.RoomDB.RoomEntity
import com.example.pharmeasy_clone.Value
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.example.pharmeasy_clone.Repository.RoomDB.SearchEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomDBViewModel(context: Context) : ViewModel() {
    private var roomDatabaseModel = RoomDatabaseModel.getDataBaseObject(context)
    private var dataDAO: RoomDao = roomDatabaseModel.getDao()

    fun insertData(roomEntity: RoomEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            dataDAO.insertData(roomEntity)
        }
    }

    fun deleteData(roomEntity: RoomEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            dataDAO.deleteData(roomEntity)
            //delete from fire base
            FirebaseDatabase.getInstance().reference.child(Value.getNum()+"")
                .child("Buy").child(roomEntity.name).removeValue()
        }
    }

    fun updateData(roomEntity: RoomEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            dataDAO.updateData(roomEntity)
        }
    }

    fun getCartData(): LiveData<List<RoomEntity>> {
        return dataDAO.getCartList()
    }

    fun getCartItem(id: Int): RoomEntity {
        return dataDAO.getCartItem(id)
    }

    fun getSearchList(): LiveData<List<SearchEntity>> {
        return dataDAO.getSearchList()
    }

    fun deleteSearch(searchEntity: SearchEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            dataDAO.deleteSearch(searchEntity)
        }
    }

    fun insertSearch(searchEntity: SearchEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            dataDAO.insertData(searchEntity)
        }
    }

}