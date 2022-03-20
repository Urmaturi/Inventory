package com.example.inventory.addNewGods

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventory.REPOSITORY
import com.example.inventory.database.Goods
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewGoodsViewModel: ViewModel() {
    fun insert(goods: Goods, onSuccess:() -> Unit) = viewModelScope.launch(Dispatchers.IO) {
        REPOSITORY.insertGoods(goods)
        {
            onSuccess
        }
    }

}