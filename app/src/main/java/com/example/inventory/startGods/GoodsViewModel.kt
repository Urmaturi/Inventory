package com.example.inventory.startGods

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.inventory.database.Goods
import com.example.inventory.database.InventoryDataBase
import com.example.inventory.repository.BaseRepository
import kotlinx.coroutines.Dispatchers

class GoodsViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Goods>>
    private val repository: BaseRepository
    init {
        val userDao = InventoryDataBase.getInstance(
            application
        ).getGoodsDao()
        repository = BaseRepository(userDao)
        readAllData = repository.readAllData
    }
    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }

    fun deleteAllUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUsers()
        }
    }
  }










}
