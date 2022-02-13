package com.waffarad.android.models

/**
 * Product is the total tax on order total.
 * @property productId product Id.
 * @property name product name.
 * @property quantity quantity of product in the order.
 * @property discount total discount of total quantity.
 * @property salePrice price after sale.
 * @property listPrice original price.
 * @property url product Url.
 * @property sku product sku.
 * @property isTaxable flag if the product include taxes.
 * @property imageUrl product image in website.
 * @property categories list of product category names.
 */
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
     val imageUrl : String? = "",
    val categories : List<String>? = listOf()
)

