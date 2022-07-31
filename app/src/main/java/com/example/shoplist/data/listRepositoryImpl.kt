package com.example.shoplist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoplist.domain.ShopItem
import com.example.shoplist.domain.ShopListRepository
import java.lang.Exception

object listRepositoryImpl:ShopListRepository {

    private var shopList = MutableLiveData<List<ShopItem>>()
    private var shopIt = sortedSetOf(Comparator<ShopItem> { p0, p1 -> p0.id.compareTo(p1.id)})

    init {
        for (i in 0..10) {
            val item = ShopItem("Name $i", i , true)
            addItem(item)
        }
    }

    private var autoIncrementId = 0

    override fun getItemList(): LiveData<List<ShopItem>> {
        return shopList
    }

    private fun updateList() {
        shopList.value = shopIt.toList()
    }

    override fun getItemFromId(id: Int): ShopItem {
        return shopIt.find { it.id == id } ?: throw Exception("")
    }

    override fun editItem(shopItem: ShopItem) {
        val oldElement = getItemFromId(shopItem.id)
        shopIt.remove(oldElement)
        addItem(shopItem)
    }

    override fun deleteItem(shopItem: ShopItem) {
        shopIt.remove(shopItem)
        updateList()
    }

    override fun addItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED) {
            shopItem.id = autoIncrementId++
        }
        shopIt.add(shopItem)
        updateList()
    }
}