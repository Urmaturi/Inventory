package com.example.inventory.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "goods_in_the_store_table")
data class Goods(
    @PrimaryKey(autoGenerate = true) val goodId: Long = 0L,
    @ColumnInfo(name = "good_name") val goodName: String,
    @ColumnInfo(name = "good_cost") val goodCost: Int,
    @ColumnInfo(name = "goods_manufacturer") val goodsManufacturer: String,
    @ColumnInfo(name = "number_of_goods") val amountOfGoods: Int,
    @ColumnInfo(name= "archive_of_goods") val archiveOfGoods : Boolean
    )