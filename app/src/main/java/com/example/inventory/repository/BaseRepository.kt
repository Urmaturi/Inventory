package com.example.inventory.repository

import androidx.lifecycle.LiveData
import com.example.inventory.database.Goods

interface BaseRepository {
    val allGoods :  LiveData<List<Goods>>
    suspend fun insertGoods( goods : Goods, onSuccess:() ->Unit)
    suspend fun deleteGood( key : Long, onSuccess:() ->Unit)

}