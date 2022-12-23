@file:Suppress("unused")

package com.example.btrade.ui.product

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.example.btrade.databinding.DialogShowProductBinding

class DialogShowProduct:DialogFragment(), View.OnClickListener {
    private lateinit var binding : DialogShowProductBinding
    private var product: Product? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.requireActivity())
        binding = DialogShowProductBinding.inflate(layoutInflater)
        binding.txtName.text = product!!.name
        binding.txtDescription.text = product!!.description
        binding.txtCondition.text = product!!.condition
        binding.txtValue.text = "\$ ${product!!.value.toString()}"

        builder.setView(binding.root)
        binding.btnDelete.setOnClickListener(this)
        return  builder.create()

    }
    //receive a product from main activity
    fun sendProductSelected(selected: Product){
        product = selected
    }

    override fun onClick(view: View?) {
        when(view?.id){
            binding.btnDelete.id -> {
                val productActivity = activity as ProductActivity?
                productActivity?.deleteProduct(product!!)
                dismiss()
            }
        }

    }
}