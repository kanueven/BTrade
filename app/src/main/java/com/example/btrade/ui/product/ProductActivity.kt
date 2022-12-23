package com.example.btrade.ui.product

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btrade.databinding.ContentMainBinding
import com.example.btrade.serializer.JSONSerializer
import com.google.firebase.auth.FirebaseAuth

class ProductActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ContentMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var category:String

    // create list for holding products
    private var mSerializer: JSONSerializer? = null
    private var catSerializer: JSONSerializer? = null
    private var productList:ArrayList<Product>? = null
    private var recyclerView: RecyclerView? = null
    private var adapter: ProductAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContentMainBinding.inflate(layoutInflater)
//        auth = Firebase.auth
//        var user = auth.currentUser
//        if (user != null){
//
//        }


        setContentView(binding.root)
        //add button event listener for adding notes

        binding.btnNew.setOnClickListener(this)

        mSerializer = JSONSerializer("BarterTrade.json",
            applicationContext)
        try {
            productList = mSerializer!!.load()
        } catch (e: Exception) {
            productList = ArrayList()
            Log.e("Error loading notes: ", "", e)
        }
        //set recyclerView and adapter variables
        recyclerView = binding.recyclerView
        adapter = ProductAdapter(this, this.productList!!)//productList is the list datatype holding Notes

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()

        //set the adapter
        recyclerView!!.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        reload()
        // Add a neat dividing line between items in the list
        val prefs = getSharedPreferences("Barter Trade", Context.MODE_PRIVATE)
        val showDivider = prefs.getBoolean("divider",true)
        if (showDivider){
            recyclerView!!.addItemDecoration(
                DividerItemDecoration(
                    this,
                    LinearLayoutManager.VERTICAL
                )
            )
        }else{
            // check there are some dividers
            // or the app will crash
            if (recyclerView!!.itemDecorationCount > 0)
                recyclerView!!.removeItemDecorationAt(0)
        }

    }

    override fun onPause() {
        super.onPause()
        saveProducts()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun createNewProduct(product: Product) {
        catSerializer = JSONSerializer("$category.json",
            applicationContext)
        catSerializer?.save(listOf(product))
        productList?.add(product)
        reload()
        adapter?.notifyDataSetChanged()
    }

    fun showNote(adapterPosition: Int) {
        val dialog = DialogShowProduct()
        dialog.sendProductSelected(productList!![adapterPosition])
        dialog.show(supportFragmentManager,"")
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id){
                binding.btnNew.id -> {
                    val dialog = DialogGetCategories()
                    dialog.show(supportFragmentManager,"123")
                }
            }
        }
    }
    private fun saveProducts() {
        try {
            mSerializer!!.save(this.productList!!)
        } catch (e: Exception) {
            Toast.makeText(this, "Error saving products", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteProduct(product: Product) {
        productList!!.remove(product)
        reload()
        adapter?.notifyDataSetChanged()
    }
    private fun reload(){
        if(productList.isNullOrEmpty()){
            binding.txtEmpty.visibility = View.VISIBLE
            binding.txtEmptySub.visibility = View.VISIBLE
        }else{
            binding.txtEmpty.visibility = View.GONE
            binding.txtEmptySub.visibility = View.GONE
        }
    }

    fun setCategory(name: String) {
        category = name.lowercase()
        val dialog = DialogNewProduct(name)
        dialog.show(supportFragmentManager,"")
    }


}
