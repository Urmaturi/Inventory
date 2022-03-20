package com.example.inventory.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Goods::class], version = 1, exportSchema = false)

abstract class InventoryDataBase : RoomDatabase() {
    abstract fun getGoodsDao(): GoodsDataBaseDao

    companion object {
        private var database: InventoryDataBase? = null


        @Synchronized
        fun getInstance(context: Context): InventoryDataBase {
            return if (database == null) {
                database = Room.databaseBuilder(context,InventoryDataBase::class.java,"db").build()
                database as InventoryDataBase
            } else {
                database as InventoryDataBase
            }
        }


    }

}