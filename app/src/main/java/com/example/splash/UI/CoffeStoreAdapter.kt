 package com.example.splash.UI

 import android.view.LayoutInflater
 import android.view.ViewGroup
 import androidx.recyclerview.widget.ListAdapter
 import com.example.splash.R

 class CoffeStoreAdapter (private val onCLickItem: (imagem: Int) -> Unit): ListAdapter<CoffeStoreItemPresentation, CoffeStoreViewHolder>(CoffeStoreDiffUtil()){

     private val list = mutableListOf<CoffeStoreItemPresentation>()

     fun add(coffeStoreItemPresentation: CoffeStoreItemPresentation){

         list.add(coffeStoreItemPresentation)
     }
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeStoreViewHolder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_coffe_store, parent, false)
         return CoffeStoreViewHolder(view, onCLickItem)
     }

     override fun onBindViewHolder(holder: CoffeStoreViewHolder, position: Int) {
         holder.bind(getItem(position))
     }


 }