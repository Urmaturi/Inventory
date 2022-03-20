package com.example.inventory.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "goods_in_the_store_table")
data class Goods(
    @PrimaryKey(autoGenerate = true) var goodId: Int = 0,
    @ColumnInfo(name = "good_name") var goodName: String,
    @ColumnInfo(name = "good_cost") var goodCost: Int,
    @ColumnInfo(name = "goods_manufacturer") var goodsManufacturer: String,
    @ColumnInfo(name = "number_of_goods") var amountOfGoods: Int,
    @ColumnInfo(name= "archive_of_goods") var archiveOfGoods : Boolean
    )