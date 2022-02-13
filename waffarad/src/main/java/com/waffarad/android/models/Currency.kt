package com.waffarad.android.models

/**
 * Currency is the applied coupon in order.
 * @property name Currency name.
 * @property code Currency iso code.
 * @property symbol Currency symbol.
 */
data class Currency(
    val name: String?="" ,
    val code: String?="" ,
    val symbol: String?=""
)