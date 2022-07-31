package com.example.shoplist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoplist.data.listRepositoryImpl
import com.example.shoplist.domain.DeleteItem
import com.example.shoplist.domain.EditItem
import com.example.shoplist.domain.ItemUseCase
import com.example.shoplist.domain.ShopItem

class MyViewModel: ViewModel() {

    val repository = listRepositoryImpl

    val getList = ItemUseCase(repository)
    val deleteItem = DeleteItem(repository)
    val editItem = EditItem(repository)

    val list = getList.getItemList()

    fun deleteItem(shopItem: ShopItem) {
        deleteItem.deleteItem(shopItem)
    }

    fun editItem(shopItem: ShopItem) {
        val newItem = shopItem.copy(state = !shopItem.state)
        editItem.editItem(newItem)
    }
}