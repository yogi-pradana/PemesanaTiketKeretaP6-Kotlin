package com.p3b1yogi.pemesanatiketkeretap6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.p3b1yogi.pemesanatiketkeretap6.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data from intent
        val nama = intent.getStringExtra("nama")
        val jam = intent.getStringExtra("jam")
        val tanggal = intent.getStringExtra("tanggal")
        val tujuan = intent.getStringExtra("tujuan")

        // Display the data on the second activity
        binding.nama.text = "Nama   : $nama"
        binding.jam.text = "Jam     : $jam"
        binding.tanggal.text = "Tanggal: $tanggal"
        binding.tujuan.text = "Tujuan  : $tujuan"
    }
}
