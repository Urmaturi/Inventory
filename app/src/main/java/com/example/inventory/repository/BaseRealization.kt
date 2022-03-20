package com.example.inventory.repository

import androidx.lifecycle.LiveData
import com.example.inventory.database.Goods
import com.example.inventory.database.GoodsDataBaseDao

  class BaseRealization(private val goodsDataBaseDao: GoodsDataBaseDao): BaseRepository {
    override  val allGoods: LiveData<List<Goods>>
        get() = goodsDataBaseDao.getAllGoods()

    override suspend fun insertGoods(goods: Goods, onSuccess: () -> Unit) {
        goodsDataBaseDao.insert(goods)
        onSuccess()
    }

    override suspend fun deleteGood(key: Long, onSuccess: () -> Unit) {
        goodsDataBaseDao.deleteItem(key)
        onSuccess()
    }


}