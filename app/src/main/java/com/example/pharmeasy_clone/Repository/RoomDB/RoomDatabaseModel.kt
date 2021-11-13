package com.example.pharmeasy_clone.Repository.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RoomEntity::class], version = 1)
abstract class RoomDatabaseModel : RoomDatabase() {
    abstract fun getDao(): RoomDao

    companion object {
        private var INSTANCE: RoomDatabaseModel? = null

        fun getDataBaseObject(context: Context): RoomDatabaseModel {
            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDatabaseModel::class.java,
                    "cart"
                )

                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()

                return INSTANCE!!
            }
            return INSTANCE!!
        }
    }
}