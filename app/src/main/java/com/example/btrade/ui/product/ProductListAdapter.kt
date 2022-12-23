package com.example.btrade.ui.product

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.btrade.databinding.ListItemBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Suppress("KDocUnresolvedReference")
class ProductListAdapter(
    val activity: ProductListActivity,
    private val productList:List<Product>?) : RecyclerView.Adapter<ProductListAdapter.ListItemHolder>()
 {
     private lateinit var auth: FirebaseAuth
     private lateinit var category:String
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
         val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context))
         category = ""
         auth = Firebase.auth
         return ListItemHolder(binding)
     }

     override fun onBindViewHolder(holder: ListItemHolder, position: Int) {
         val product = productList!![position]

         holder.name.text = product.name
         // Show the first 15 characters of the actual description
         if (product.description!!.length > 20){
             holder.description.text = product.description!!.substring(0,20)
         }else{
             holder.description.text = product.description
         }
         holder.condition.text = product.condition
         holder.value.text = "\$ ${product.value.toString()}"


     }

     override fun getItemCount(): Int {
         if (productList != null){
             return productList.size
         }//error
         return -1
     }

     inner class ListItemHolder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root), OnClickListener {
         val view = binding.root
         var name = binding.txtName
         var description = binding.txtDesc
         var condition = binding.txtCondition
         var value = binding.txtValue

         init {
             view.isClickable = true
             view.setOnClickListener(this)
         }
         override fun onClick(view: View?) {
             activity.showProduct(bindingAdapterPosition)
         }


     }

 }