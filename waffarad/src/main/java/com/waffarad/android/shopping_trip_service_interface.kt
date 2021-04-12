package com.waffarad.android


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.*


interface ShoppingTripServiceInterface {

    @POST("/mobile/addorder")
    fun postbackShoppingTrip(
        @Query("af_id") affiliateId: String?,
        @Query("subid") subId: String?,
        @Body() body: Any?
    ): Call<Any>

}

