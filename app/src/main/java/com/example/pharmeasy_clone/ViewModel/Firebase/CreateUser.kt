package com.example.pharmeasy_clone.ViewModel.Firebase

import com.example.pharmeasy_clone.FirebasbeModel.model
import com.example.pharmeasy_clone.Value
import com.google.firebase.database.FirebaseDatabase

class CreateUser(var model: model,var item:String) {
    fun addData()
        {
            var db= FirebaseDatabase.getInstance()
            var root=db.getReference()
            root.child(Value.getNum()+"").child("Buy").child("$item").setValue(model)
        }
}