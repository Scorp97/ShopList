package com.example.shoplist.domain

class ItemUseCase(private val shopListRepository: ShopListRepository) {

    fun getItemList() : List<ShopItem> {
       return shopListRepository.getItemList()
    }
}