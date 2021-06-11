package com.example.splash.UI

import androidx.recyclerview.widget.DiffUtil

class CoffeStoreDiffUtil : DiffUtil.ItemCallback<CoffeStoreItemPresentation>() {

    override fun areItemsTheSame(oldItem: CoffeStoreItemPresentation, newItem: CoffeStoreItemPresentation): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CoffeStoreItemPresentation, newItem: CoffeStoreItemPresentation): Boolean {
        return oldItem.equals(newItem)
    }
}