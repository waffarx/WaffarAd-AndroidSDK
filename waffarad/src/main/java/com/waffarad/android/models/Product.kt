package com.waffarad.android.models

data class Product(
    val productId: Int,
    val name : String ,
    val quantity : Int ,
    val discount: Double,
    val salePrice : Double,
    val listPrice : Double,
    val url : String?="" ,
    val sku : String?="" ,
    val isTaxable : Boolean? =false,
    val extendedSalePrice : Double?=0.0,
    val imageUrl : String? = "",
    val extendedListPrice : Double?= 0.0,
    val categories : List<String>? = listOf()
)

