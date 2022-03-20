package com.example.inventory.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GoodsDataBaseDao {
    @Insert(onConflict =  OnConflictStrategy.IGNORE) fun insert(goods: Goods)
    @Update fun update(goods: Goods)
    @Query("SELECT * FROM goods_in_the_store_table WHERE goodId= :key")   fun getGoodItem(key: Long): Goods
    @Query("DELETE FROM goods_in_the_store_table  WHERE goodId= :key")    fun deleteItem(key: Long): Goods
    @Query("SELECT * FROM goods_in_the_store_table WHERE archive_of_goods='false' ORDER BY goodId DESC")    fun getAllGoods(): LiveData<List<Goods>>
    @Query("SELECT * FROM goods_in_the_store_table WHERE archive_of_goods='true' ORDER BY goodId DESC")    fun getAllGoodsInArchive(): LiveData<List<Goods>>
}

