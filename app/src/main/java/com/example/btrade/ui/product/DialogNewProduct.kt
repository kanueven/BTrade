package com.example.btrade.ui.product

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.btrade.databinding.DialogNewProductBinding

class DialogNewProduct(val category: String) :DialogFragment(){
    private lateinit var binding: DialogNewProductBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.requireActivity())
        //inflate the view with our layout
        binding = DialogNewProductBinding.inflate(layoutInflater)
        binding.btnCategory.text = this.category
        //lets add the builder codes
        builder.setView(binding.root).setMessage("New Product")
        //handle the cancel button
        binding.btnCancel.setOnClickListener {
            dismiss()
        }

        binding.btnOk.setOnClickListener {
            //Create variables to hold our inputs
            val name = binding.edtName.text.toString()
            val desc = binding.edtDescription.text.toString()
            val cond = binding.edtCondition.text.toString()
            val value = binding.edtValue.text.toString()


            // Validate that no field is empty before creating product
            if (validate(name,desc,cond,value)){
                //create a new product
                val product = Product()
                //match it to the user's entries
                product.name = name
                product.description = desc
                product.condition = cond
                product.value = value.toInt()
                product.category = category
                //get main activity
                val callingActivity = activity as ProductActivity?
                //pass the note to main activity
                callingActivity!!.createNewProduct(product)
                dismiss()
            }else{
                Toast.makeText(this.context, "Fill out all fields", Toast.LENGTH_SHORT).show()
            }

        }
        return builder.create()
    }



    private fun validate(name: String?, description: String?, condition: String?, value: String?):Boolean {
        return !(name.isNullOrEmpty() or description.isNullOrEmpty() or condition.isNullOrEmpty() or value.isNullOrEmpty())
    }

}