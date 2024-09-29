package com.p3b1yogi.pemesanatiketkeretap6

import PesanTiketDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.p3b1yogi.pemesanatiketkeretap6.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private lateinit var binding: ActivityMainBinding
    private var selectedTime: String = ""
    private var selectedDate: String = ""
    private var selectedCity: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the spinner with city options
        val cities = resources.getStringArray(R.array.Tujuan) // Use the string array from resources
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cities)
        binding.Tujuan.adapter = adapter

        // Time picker
        binding.Time.setOnClickListener {
            val timePicker = TimePicker()
            timePicker.show(supportFragmentManager, "timePicker")
        }

        // Date picker
        binding.Calendar.setOnClickListener {
            val datePicker = DatePicker()
            datePicker.show(supportFragmentManager, "datePicker")
        }

        // Pesan Tiket Button
        binding.btnPesanTiket.setOnClickListener {
            val userName = binding.Username.text.toString()
            selectedCity = binding.Tujuan.selectedItem.toString()

            if (userName.isEmpty() || selectedTime.isEmpty() || selectedDate.isEmpty() || selectedCity.isEmpty()) {
                Toast.makeText(this, "Mohon lengkapi semua data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Menampilkan dialog konfirmasi
            val dialog = PesanTiketDialog()
            dialog.arguments = Bundle().apply {
                putString("userName", userName)
                putString("selectedTime", selectedTime)
                putString("selectedDate", selectedDate)
                putString("selectedCity", selectedCity)
            }
            dialog.show(supportFragmentManager, "PesanTiketDialog")
        }
    }

    // Handle DatePickerDialog result
    override fun onDateSet(view: android.widget.DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        selectedDate = "$dayOfMonth/${month + 1}/$year"
        binding.Calendar.setText(selectedDate)
    }

    // Handle TimePickerDialog result
    override fun onTimeSet(view: android.widget.TimePicker?, hourOfDay: Int, minute: Int) {
        selectedTime = String.format("%02d:%02d", hourOfDay, minute) // Format time
        binding.Time.setText(selectedTime)
    }
}
