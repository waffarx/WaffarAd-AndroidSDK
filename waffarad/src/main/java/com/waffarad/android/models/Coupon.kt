package com.waffarad.android.models

/**
 * Coupon is the applied coupon in order.
 * @property id coupon id.
 * @property code coupon code.
 * @property discountedAmount discounted amount in total order.
 * @property displayName coupon display name.
 */
data class Coupon(
        val id :Int? = 0,
        val code: String?= "" ,
        val discountedAmount : Double?= 0.0 ,
        val displayName : String?= ""
)