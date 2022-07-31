package com.example.shoplist.domain

class GetItemId(private val shopListRepository: ShopListRepository) {

    fun getItemFromId(id: Int): ShopItem {
        return shopListRepository.getItemFromId(id)
    }
}