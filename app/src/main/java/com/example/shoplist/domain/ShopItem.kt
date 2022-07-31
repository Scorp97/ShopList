package com.example.shoplist.domain

data class ShopItem(
    val name: String,
    val count: Int,
    var state: Boolean,
    var id:Int = UNDEFINED
) {

    companion object {
        const val UNDEFINED = -1
    }
}



