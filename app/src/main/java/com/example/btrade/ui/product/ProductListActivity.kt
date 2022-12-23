package com.example.btrade.ui.product

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.btrade.databinding.ActivityProductListBinding
import com.example.btrade.serializer.JSONSerializer

class ProductListActivity : AppCompatActivity() {
    private lateinit var binding:ActivityProductListBinding
    private lateinit var prefs:SharedPreferences
    //product loading classes
    private var catSerializer: JSONSerializer? = null
    private var productList:ArrayList<Product>? = null
    private var recyclerView: RecyclerView? = null
    private var adapter: ProductListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = getSharedPreferences("BarterTrade", MODE_PRIVATE)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        val category = prefs.getString("category","service")
        binding.textView.text = category
        setContentView(binding.root)

        //set adapter and load data
        catSerializer = JSONSerializer("$category.json",
            applicationContext)
        try {
            productList = catSerializer!!.load()

        } catch (e: Exception) {
            productList = ArrayList()
            Log.e("Error loading product: ", "", e)
        }

        //set recyclerView and adapter variables
        recyclerView = binding.productsRecyler
        adapter = ProductListAdapter(this, this.productList)//productList is the list datatype holding Notes

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()

        //set the adapter
        recyclerView!!.adapter = adapter
    }
    override fun onResume() {
        super.onResume()
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

    fun showProduct(position: Int) {
        val dialog = DialogBidProduct()
        dialog.sendProductSelected(productList!![position])
        dialog.show(supportFragmentManager,"")
    }
}