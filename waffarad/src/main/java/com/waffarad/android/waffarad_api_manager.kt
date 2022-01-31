package com.waffarad.android
import Order
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object WaffarAdAPIManager{
    init {

    }
    fun  postback(af_id:String? , subid:String? ,order:Order ,  waffarAdPostBack: WaffarAdPostBack){
        val request = WaffarAdServiceBuilder.buildService(ShoppingTripServiceInterface::class.java)

        val call = request.postbackShoppingTrip( af_id,subid,order)

        call.enqueue(object :  Callback<Any>{
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                if (response.isSuccessful){
                    print("Piso: asdasdasdasdsa")
                    waffarAdPostBack.onSuccess()
//                    progress_bar.visibility = View.GONE
//                    recyclerView.apply {
//                        setHasFixedSize(true)
//                        layoutManager = LinearLayoutManager(this@MainActivity)
//                        adapter = MoviesAdapter(response.body()!!.results)
                    }
                }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                waffarAdPostBack.onFail()
            }


        })
    }
}