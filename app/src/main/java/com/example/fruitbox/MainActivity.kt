package com.example.fruitbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruitbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fruitList = listOf(
            Fruit(R.drawable.semangka, "Semangka", "Hijau"),
            Fruit(R.drawable.jeruk, "Jeruk", "Kuning"),
            Fruit(R.drawable.kelengkeng, "Kelengkeng", "Cokelat"),
            Fruit(R.drawable.stroberi, "Stroberi", "Merah"),
            Fruit(R.drawable.anggur, "Anggur", "Ungu")
        )

        val adapter = FruitAdapter(fruitList, this)
        binding.rvFruit.adapter = adapter
        binding.rvFruit.layoutManager = LinearLayoutManager(this)

    }

    fun onItemClick(data: Fruit) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_FRUIT, data)
        startActivity(intent)

        // Menampilkan pesan toast saat item diklik
        Toast.makeText(this, "Anda memilih buah: ${data.name}", Toast.LENGTH_SHORT).show()
    }
}