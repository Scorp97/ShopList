package com.example.shoplist.data

import com.example.shoplist.domain.ShopItem
import com.example.shoplist.domain.ShopListRepository
import java.lang.Exception

object listRepositoryImpl:ShopListRepository {

    private var shopIt = mutableListOf<ShopItem>()

    private var autoIncrementId = 0

    override fun getItemList(): List<ShopItem> {
        return shopIt.toList()
    }

    override fun getItemFromId(id: Int): ShopItem {
        return shopIt.find { it.id == ShopItem.UNDEFINED } ?: throw Exception("")
    }

    override fun editItem(shopItem: ShopItem) {
        val oldElement = getItemFromId(shopItem.id)
        shopIt.remove(oldElement)
        addItem(shopItem)
    }

    override fun deleteItem(shopItem: ShopItem) {
        shopIt.remove(shopItem)
    }

    override fun addItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED) {
            shopItem.id = autoIncrementId++
        }
        shopIt.add(shopItem)
    }
}