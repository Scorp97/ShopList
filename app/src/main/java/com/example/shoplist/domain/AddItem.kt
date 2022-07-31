package com.example.shoplist.domain

class AddItem(private val shopListRepository: ShopListRepository) {

    fun addItem(shopItem: ShopItem) {
        shopListRepository.addItem(shopItem)
    }
}