package com.example.pharmeasy_clone.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pharmeasy_clone.Repository.RoomDB.RoomDao
import com.example.pharmeasy_clone.Repository.RoomDB.RoomDatabaseModel
import com.example.pharmeasy_clone.Repository.RoomDB.RoomEntity
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
}