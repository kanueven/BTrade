package com.example.btrade.serializer

import android.content.Context
import com.example.btrade.ui.product.Product
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONTokener
import java.io.*

class JSONSerializer(private val filename:String,private val context:Context) {
    @Throws(IOException::class,JSONException::class)
    fun save(products : List<Product>){
        // make a JSON array and feed it the data
        val jArray = JSONArray()
        for (n in products){
            jArray.put(n.convertToJSON())
        }
        // now write it to the private disk space of our app
        var writer:Writer? = null
        try {
            val  out = context.openFileOutput(filename,Context.MODE_PRIVATE)
            writer = OutputStreamWriter(out)
            writer.write(jArray.toString())
        }finally {
            writer?.close()
        }
    }
    @Throws(IOException::class,JSONException::class)
    fun load():ArrayList<Product>{
        val noteList = ArrayList<Product>()
        var reader:BufferedReader? = null

        try {
            val `in` = context.openFileInput(filename)
            reader = BufferedReader(InputStreamReader(`in`))
            val jsonString = StringBuilder()
            for (line in reader.readLines()){
                jsonString.append(line)
            }

            val jArray = JSONTokener(jsonString.toString()).nextValue() as JSONArray

            for (i in 0 until  jArray.length()){
                noteList.add(Product(jArray.getJSONObject(i)))
            }

        }catch (e:FileNotFoundException){
            // we will ignore this one, since it happens
            // when we start fresh. You could add a log here.
        }finally {
            reader?.close()
        }
        return noteList
    }
}