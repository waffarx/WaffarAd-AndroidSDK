package com.waffarad.android.models

data class Coupon(
        val id :Int? = 0,
        val code: String?= "" ,
        val discountedAmount : Double?= 0.0 ,
        val displayName : String?= ""
)