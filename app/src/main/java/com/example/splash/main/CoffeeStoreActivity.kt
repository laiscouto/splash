package com.example.splash.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.splash.Infra.MotivationConstantes.Companion.KEY_IMG
import com.example.splash.R
import com.example.splash.UI.CarrinhoCoffeStore
import com.example.splash.UI.CoffeStoreAdapter
import com.example.splash.UI.CoffeStoreItemPresentation
import kotlinx.android.synthetic.main.activity_recycler_store_coffe.*

class CoffeeStoreActivity : AppCompatActivity() {
    private val adapter = CoffeStoreAdapter(:: handlerClick)
    private val list = listOf(
            CoffeStoreItemPresentation(R.drawable.java),
            CoffeStoreItemPresentation(R.drawable.juan),
            CoffeStoreItemPresentation(R.drawable.tiru),
            CoffeStoreItemPresentation(R.drawable.coffe),
            CoffeStoreItemPresentation(R.drawable.tirus))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_store_coffe)

        if (supportActionBar != null){
            supportActionBar!!.hide()
        }

        coffeList()
        activity_recycler_store_coffe.layoutManager = GridLayoutManager(this, 1)
        activity_recycler_store_coffe.adapter = this.adapter

    }

    fun handlerClick(imagem: Int) {
        val intent = Intent(this, CarrinhoCoffeStore::class.java).apply {
            putExtra(KEY_IMG,imagem)
        }
        startActivity(intent)
    }

    fun coffeList() {
        adapter.submitList(list)
    }
}
    
