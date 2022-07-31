package com.example.shoplist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.shoplist.R
import com.example.shoplist.domain.ShopItem

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MyViewModel
    private lateinit var ll: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ll = findViewById(R.id.ll_shop_list)
        viewModel = ViewModelProvider(this)[MyViewModel::class.java]
        viewModel.list.observe(this, {
            showList(it)
        })
    }

    fun showList(list: List<ShopItem>) {
        ll.removeAllViews()
        for (shopItem in list) {
            val state = if (!shopItem.state) {
                R.layout.item_shop_disabled
            } else {
                R.layout.item_shop_enabled
            }
            val view = LayoutInflater.from(this).inflate(state, ll, false)
            val name = view.findViewById<TextView>(R.id.tv_name)
            val count = view.findViewById<TextView>(R.id.tv_count)
            name.text = shopItem.name
            count.text = shopItem.count.toString()
            view.setOnLongClickListener {
                viewModel.editItem(shopItem)
                true
            }
            ll.addView(view)
        }
    }
}