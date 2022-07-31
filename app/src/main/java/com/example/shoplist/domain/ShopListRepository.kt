package com.example.shoplist.domain

interface ShopListRepository {

    fun getItemList() : List<ShopItem>

    fun getItemFromId(id: Int): ShopItem

    fun editItem(shopItem: ShopItem)

    fun deleteItem(shopItem: ShopItem)

    fun addItem(shopItem: ShopItem)
}