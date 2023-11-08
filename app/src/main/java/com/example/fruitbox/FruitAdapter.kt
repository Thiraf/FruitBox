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
                    // Menetapkan gambar, nama, dan warna buah ke tampilan ViewHolder
                    fruitImage.setImageResource(data.image)
                    nameTxt.text = data.name
                    colorsTxt.text= data.color

                    // Menangani klik item pada RecyclerView
                    itemView.setOnClickListener{
                        listener.onItemClick(data)
                    }
                }
            }
        }

    // Membuat tampilan baru (ViewHolder) sesuai dengan layout item_fruit.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFruitViewHolder {
        val binding = ItemFruitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemFruitViewHolder(binding)
    }

    // Mengembalikan jumlah item dalam daftar buah
    override fun getItemCount(): Int {
        return listFruit.size
    }

    // Mengikat data buah ke tampilan ViewHolder
    override fun onBindViewHolder(holder: ItemFruitViewHolder, position: Int) {
        holder.bind(listFruit[position])
    }
}