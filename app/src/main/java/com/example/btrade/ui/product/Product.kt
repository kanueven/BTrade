@file:Suppress("PrivatePropertyName")

package com.example.btrade.ui.product

import com.google.firebase.auth.FirebaseUser
import org.json.JSONException
import org.json.JSONObject

class Product {
    //create a class Product that will contain all the attributes of a PRODUCT
    var name: String? = null
    var description:String? = null
    var condition:String? = null
    var category:String? = null
    var value:Int? = null
    private var owner:FirebaseUser? = null

    //JSON
    private val JSON_NAME = "name"
    private val JSON_DESCRIPTION = "description"
    private val JSON_CONDITION = "condition"
    private val JSON_CATEGORY = "category"
    private val JSON_VALUE = "value"

    // Constructor
    // Only used when created from a JSONObject
    @Throws(JSONException::class)
    constructor(jo:JSONObject){
        name = jo.getString(JSON_NAME)
        description = jo.getString(JSON_DESCRIPTION)
        condition = jo.getString(JSON_CONDITION)
        category = jo.getString(JSON_CATEGORY)
        value = jo.getInt(JSON_VALUE)

    }
    // Now we must provide an empty default constructor for
    // when we create a Product to pass to the new product dialog
    constructor(){}

    // Create code to convert to JSON
    @Throws(JSONException::class)
    fun convertToJSON():JSONObject{
        val jo = JSONObject()
        jo.put(JSON_NAME,name)
        jo.put(JSON_DESCRIPTION,description)
        jo.put(JSON_CONDITION,condition)
        jo.put(JSON_CATEGORY,category)
        jo.put(JSON_VALUE,value)

        return jo
    }

    fun isMine(currentUser: FirebaseUser): Boolean {
        return this.owner == currentUser
    }

}