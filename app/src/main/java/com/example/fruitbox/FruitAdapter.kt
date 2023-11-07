package com.example.fruitbox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitbox.databinding.ItemFruitBinding

class FruitAdapter(private val listFruit: List<Fruit>, private val listener: MainActivity) :
    RecyclerView.Adapter<FruitAdapter.ItemFruitViewHolder>(){

        inner class ItemFruitViewHolder(private val binding: ItemFruitBinding): RecyclerView.ViewHolder(binding.root){
            fun bind(data: Fruit){
                with(binding){
                    fruitImage.setImageResource(data.image)
                    nameTxt.text = data.name
                    colorsTxt.text= data.color

                    itemView.setOnClickListener{
                        listener.onItemClick(data)
                    }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFruitViewHolder {
        val binding = ItemFruitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemFruitViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listFruit.size
    }

    override fun onBindViewHolder(holder: ItemFruitViewHolder, position: Int) {
        holder.bind(listFruit[position])
    }
}