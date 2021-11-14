package com.example.pharmeasy_clone.CartData

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [DBModel::class], version = 1)
abstract class CartDB : RoomDatabase() {

    abstract fun getTaskDAO(): DAO

    companion object {

        private var INSTANCE: CartDB? = null

        fun getDatabaseObject(context: Context): CartDB {

            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    CartDB::class.java,
                    "task_db"
                )

                builder.fallbackToDestructiveMigration()

                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }
        }

    }

}