package com.example.shoplist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun getItemList() : LiveData<List<ShopItem>>

    fun getItemFromId(id: Int): ShopItem

    fun editItem(shopItem: ShopItem)

    fun deleteItem(shopItem: ShopItem)

    fun addItem(shopItem: ShopItem)
}