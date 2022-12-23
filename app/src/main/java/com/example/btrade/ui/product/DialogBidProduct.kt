package com.example.btrade.ui.product

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.btrade.databinding.DialogBidProductBinding

class DialogBidProduct: DialogFragment() {
    private lateinit var _product: Product
    private lateinit var binding: DialogBidProductBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogBidProductBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireContext())
        binding.txtProductName.text = _product.name
        binding.txtProductDescription.text = _product.description
        binding.txtProductValue.text = _product.value.toString()
        binding.txtProductCondition.text = _product.condition
        builder.setView(binding.root)
        return builder.create()
    }

    fun sendProductSelected(product: Product) {
        _product = product
    }
}
