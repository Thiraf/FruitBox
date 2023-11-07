package com.example.fruitbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fruitbox.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_FRUIT = "extra_fruit"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fruit = intent.getParcelableExtra<Fruit>(EXTRA_FRUIT)
        fruit?.let {
            binding.detailImg.setImageResource(it.image)
            binding.detailName.text = it.name
            binding.detailColor.text = it.color
        }

        binding.btnBack.setOnClickListener{
            onBackPressed()
        }
    }
}