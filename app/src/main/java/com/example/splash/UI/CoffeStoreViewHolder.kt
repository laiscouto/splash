package com.example.splash.UI

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_coffe_store.view.*

class CoffeStoreViewHolder(itemView: View, private val onCLickItem: (imagem: Int) -> Unit) : RecyclerView.ViewHolder(itemView) {

    fun bind(coffeStoreItemPresentation: CoffeStoreItemPresentation) {
        itemView.setOnClickListener(){
            onCLickItem(coffeStoreItemPresentation.imagemRecyclerListCoffe)
        }
        itemView.logos_coffes.setImageResource(coffeStoreItemPresentation.imagemRecyclerListCoffe)

    }

}