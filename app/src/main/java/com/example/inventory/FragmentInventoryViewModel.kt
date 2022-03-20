package com.example.inventory

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.inventory.database.Goods
import com.example.inventory.database.InventoryDataBase
import com.example.inventory.repository.BaseRealization

class FragmentInventoryViewModel(application: Application) : AndroidViewModel(application) {
    val contex = application
    fun initDataBase() {
        val daoGoods = InventoryDataBase.getInstance(contex).goodsDao()
        REPOSITORY = BaseRealization(daoGoods)
    }

    fun getAllGoods(): LiveData<List<Goods>> {
        return REPOSITORY.allGoods
    }
}