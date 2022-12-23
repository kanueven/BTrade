package com.example.btrade.ui.product

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.example.btrade.databinding.DialogGetCategoriesBinding

class DialogGetCategories:DialogFragment(), View.OnClickListener {
    private lateinit var binding: DialogGetCategoriesBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogGetCategoriesBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(this.requireActivity())
        builder.setView(binding.root)
        binding.btnCatElectronics.setOnClickListener(this)
        binding.btnCatFashion.setOnClickListener(this)
        binding.btnCatFuniture.setOnClickListener(this)
        binding.btnCatHousehold.setOnClickListener(this)
        binding.btnCatMachine.setOnClickListener(this)
        binding.btnCatRepair.setOnClickListener(this)
        binding.btnCatService.setOnClickListener(this)
        binding.btnCatTextbooks.setOnClickListener(this)
        binding.btnCatVehicle.setOnClickListener(this)

        return builder.create()
    }

    override fun onClick(view: View?) {


        when(view?.id){
            binding.btnCatElectronics.id -> {
                setCategory(binding.btnCatElectronics.text.toString())
            }
            binding.btnCatFashion.id -> {
                setCategory(binding.btnCatFashion.text.toString())
            }
            binding.btnCatFuniture.id -> {
                setCategory(binding.btnCatFuniture.text.toString())
            }
            binding.btnCatHousehold.id -> {
                setCategory(binding.btnCatHousehold.text.toString())
            }
            binding.btnCatMachine.id -> {
                setCategory(binding.btnCatMachine.text.toString())
            }
            binding.btnCatVehicle.id -> {
                setCategory(binding.btnCatVehicle.text.toString())
            }
            binding.btnCatRepair.id -> {
                setCategory(binding.btnCatRepair.text.toString())
            }
            binding.btnCatTextbooks.id -> {
                setCategory(binding.btnCatTextbooks.text.toString())
            }

        }

    }

    private fun setCategory(name: String) {
        val callProductActivity = activity as ProductActivity?
        callProductActivity!!.setCategory(name)
        dismiss()
    }

}
