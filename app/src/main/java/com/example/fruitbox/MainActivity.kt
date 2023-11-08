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

        // Menginisialisasi binding menggunakan layout inflater
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Membuat daftar buah dengan objek-objek Fruit dan informasi gambar, nama, dan warna
        val fruitList = listOf(
            Fruit(R.drawable.semangka, "Semangka", "Hijau","Semangka adalah buah tropis yang sangat populer dengan daging merah manisnya dan banyak dijumpai di musim panas. Palestina, di sisi lain, adalah wilayah di Timur Tengah yang memiliki konflik politik yang kompleks dengan Israel. Tidak ada hubungan langsung antara semangka dan Palestina dalam konteks politik atau budaya. Pertanyaan Anda mungkin merujuk pada kampanye boikot yang beberapa orang lakukan terhadap produk semangka Israel sebagai bentuk protes terhadap kebijakan Israel terkait Palestina. Namun, tidak semua semangka berasal dari Israel, dan hal tersebut tidak secara inheren terkait dengan masalah Palestina."),
            Fruit(R.drawable.jeruk, "Jeruk", "Kuning","Jeruk adalah buah yang berasal dari tumbuhan jeruk (Citrus) dalam famili Rutaceae. Buah ini dikenal karena rasanya yang asam atau manis tergantung pada varietasnya. Jeruk memiliki kulit tebal yang melindungi daging buahnya yang lembut dan juicy. Jeruk memiliki kandungan vitamin C yang tinggi, yang penting untuk sistem kekebalan tubuh manusia. Buah ini juga mengandung serat, vitamin A, vitamin B, dan mineral seperti kalsium dan potassium.\n" + "\n" + "Jeruk memiliki berbagai jenis, termasuk jeruk manis (Citrus sinensis), jeruk nipis (Citrus aurantiifolia), jeruk bali (Citrus maxima), jeruk keprok (Citrus reticulata), dan banyak lagi. Selain dimakan segar, jeruk juga digunakan untuk membuat jus, selai, dan bahan tambahan dalam berbagai masakan dan minuman. Buah ini sangat populer di seluruh dunia dan merupakan salah satu sumber vitamin C yang paling umum dan lezat."),
            Fruit(R.drawable.kelengkeng, "Kelengkeng", "Cokelat","Kelengkeng adalah buah tropis yang berasal dari Asia Tenggara, terutama ditemukan di Indonesia, Thailand, Malaysia, Filipina, dan Vietnam. Buah kelengkeng memiliki nama ilmiah Dimocarpus longan dan termasuk dalam keluarga Sapindaceae. Buah ini memiliki kulit tipis dan berwarna coklat keabu-abuan, sementara daging buahnya transparan, manis, dan juicy. Biasanya, kelengkeng memiliki satu atau dua biji besar di bagian tengah buah.\n" + "\n" + "Buah kelengkeng dikenal dengan rasa manisnya yang unik dan tekstur daging buahnya yang kenyal. Kelengkeng sering dimakan segar, tetapi juga dapat diolah menjadi jus, sirup, atau digunakan dalam berbagai hidangan dan makanan penutup. Buah ini juga dikenal karena kandungan nutrisinya, termasuk vitamin C, vitamin B kompleks, mineral seperti potassium dan magnesium, serta antioksidan.\n" + "\n" + "Kelengkeng memiliki nilai budaya dan ekonomi yang penting di wilayah-wilayah tempat tumbuhnya. Buah ini sering dianggap sebagai buah simbol keberuntungan di beberapa budaya Asia dan sering dihadirkan dalam perayaan dan acara khusus."),
            Fruit(R.drawable.stroberi, "Stroberi", "Merah","Stroberi adalah buah kecil berwarna merah cerah yang tumbuh dari tanaman dengan nama ilmiah Fragaria × ananassa. Buah stroberi adalah anggota dari keluarga Rosaceae. Stroberi memiliki tekstur lembut dan rasa manis dengan sentuhan asam, yang membuatnya sangat populer di seluruh dunia. Buah ini memiliki biji kecil di permukaannya dan dikenal karena aromanya yang khas.\n" + "\n" + "Stroberi biasanya dimakan segar, tetapi juga digunakan dalam berbagai hidangan dan makanan penutup seperti kue, es krim, selai, dan yogurt. Buah stroberi memiliki kandungan nutrisi yang baik, termasuk vitamin C, vitamin K, serat, dan antioksidan. Selain rasanya yang lezat, stroberi juga dikenal karena manfaat kesehatannya, termasuk mendukung sistem kekebalan tubuh, menjaga kesehatan jantung, dan mendukung kesehatan kulit.\n" + "\n" + "Tanaman stroberi tumbuh merata di berbagai iklim, dan musim panas adalah waktu yang paling umum untuk panen stroberi segar. Stroberi sering dianggap sebagai salah satu buah favorit di musim panas dan digunakan dalam berbagai kreasi kuliner karena rasa dan warnanya yang menarik."),
            Fruit(R.drawable.anggur, "Anggur", "Ungu","Stroberi adalah buah kecil berwarna merah cerah yang tumbuh dari tanaman semusim dengan nama ilmiah Fragaria × ananassa. Buah stroberi memiliki tekstur lembut, biji kecil di permukaannya, dan rasa manis yang khas. Stroberi sering dimakan segar atau digunakan dalam berbagai hidangan dan makanan penutup seperti kue, es krim, selai, dan yogurt. Buah ini kaya akan vitamin C, serat, dan antioksidan, membuatnya baik untuk kesehatan. Tanaman stroberi tumbuh merata di berbagai iklim, dan musim panas adalah waktu yang paling umum untuk panen stroberi segar. Buah stroberi sangat populer di seluruh dunia dan sering dianggap sebagai buah favorit, terutama selama musim panas.")
        )

        // Membuat adapter untuk RecyclerView menggunakan daftar buah dan context dari activity ini
        val adapter = FruitAdapter(fruitList, this)
        binding.rvFruit.adapter = adapter
        binding.rvFruit.layoutManager = LinearLayoutManager(this)

    }


    // Fungsi dipanggil saat salah satu item di RecyclerView diklik
    fun onItemClick(data: Fruit) {
        // Membuat Intent untuk membuka DetailActivity dan melewatkan data buah sebagai extra
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_FRUIT, data)
        startActivity(intent)

        // Menampilkan pesan toast saat item diklik
        Toast.makeText(this, "Anda memilih buah: ${data.name}", Toast.LENGTH_SHORT).show()
    }
}