package com.example.shoplist.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ItemUseCase(private val shopListRepository: ShopListRepository) {

    fun getItemList(): LiveData<List<ShopItem>> {
        return shopListRepository.getItemList()
    }
}