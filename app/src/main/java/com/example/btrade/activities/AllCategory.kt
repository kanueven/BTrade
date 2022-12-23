package com.example.btrade.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.btrade.databinding.ActivityAllCategoryBinding
import com.example.btrade.ui.product.ProductListActivity

class AllCategory : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityAllCategoryBinding
    private lateinit var prefs:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = getSharedPreferences("BarterTrade", MODE_PRIVATE)
        binding = ActivityAllCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backPressed.setOnClickListener { super@AllCategory.onBackPressed() }
        binding.btnService.setOnClickListener(this)
        binding.btnElectronics.setOnClickListener(this)
        binding.btnFashion.setOnClickListener(this)
        binding.btnFurniture.setOnClickListener(this)
        binding.btnHousehold.setOnClickListener(this)
        binding.btnMachine.setOnClickListener(this)
        binding.btnTextbooks.setOnClickListener(this)
        binding.btnVehicles.setOnClickListener(this)
        binding.btnRepair.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val intent = Intent(this, ProductListActivity::class.java)

        when (view.id) {
            binding.btnService.id -> {
                addString("service")
            }
            binding.btnElectronics.id -> {
                addString("electronics")
            }
            binding.btnFashion.id -> {
                addString("fashion")
            }
            binding.btnFurniture.id -> {
                addString("furniture")
            }
            binding.btnHousehold.id -> {
                addString("household")
            }
            binding.btnMachine.id -> {
                addString("machine")
            }
            binding.btnTextbooks.id -> {
                addString("textbooks")
            }
            binding.btnVehicles.id -> {
                addString("vehicles")
            }
            binding.btnRepair.id -> {
                addString("repair")
            }

        }
        startActivity(intent)
    }

    private fun addString(s: String) {
        prefs.edit()
            .putString("category", s)
            .apply()
    }

}