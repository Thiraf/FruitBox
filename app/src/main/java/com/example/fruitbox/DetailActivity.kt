package com.example.fruitbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fruitbox.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    // Companion object digunakan untuk mendefinisikan konstanta yang akan digunakan sebagai kunci ekstra data
    companion object {
        const val EXTRA_FRUIT = "extra_fruit"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi binding menggunakan layout inflater
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan objek buah dari intent yang dikirimkan dari MainActivity
        val fruit = intent.getParcelableExtra<Fruit>(EXTRA_FRUIT)

        // Memeriksa apakah objek buah tidak null
        fruit?.let {
            // Menetapkan gambar, nama, warna, dan penjelasan buah ke tampilan DetailActivity
            binding.detailImg.setImageResource(it.image)
            binding.detailName.text = it.name
            binding.detailColor.text = it.color
            binding.detailExplanation.text = it.explanation
        }

        // Mengatur event handler untuk tombol kembali
        binding.btnBack.setOnClickListener{
            onBackPressed()
        }
    }
}
