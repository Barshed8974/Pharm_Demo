package com.example.pharmeasy_clone.ViewModel.Firebase

import com.example.pharmeasy_clone.FirebasbeModel.model
import com.example.pharmeasy_clone.Repository.RoomDB.RoomEntity
import com.example.pharmeasy_clone.Value
import com.google.firebase.database.FirebaseDatabase

class CreateUser(var roomEntity: RoomEntity) {
    fun addData()
        {
            var db= FirebaseDatabase.getInstance()
            var root=db.getReference()
            root.child(Value.getNum()+"").child("Buy").child("${roomEntity.name}").setValue(roomEntity)
        }
}