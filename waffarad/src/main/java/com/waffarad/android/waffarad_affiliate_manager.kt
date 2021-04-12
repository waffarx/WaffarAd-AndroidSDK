package com.waffarad.android

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle

object WaffarAdAffiliateManager {

    init {
        println("Singleton class invoked.")
    }

    fun trackAffiliateTrip(context: Context, intent: Intent): Boolean {
            val waffarAdLocalStorageManager = WaffarAdLocalStorageManager(context)
        var validTrip  = false
        if (intent.data != null) {
            val data: Uri? = intent.data
              if (waffarAdLocalStorageManager.validParams(data)) {
                waffarAdLocalStorageManager.saveAffiliateTripParams(data)
                waffarAdLocalStorageManager.saveShoppingTripTime()
                  validTrip =  true
            }
        }
        if(intent.extras != null){
            val data: Bundle? = intent.extras
              if (waffarAdLocalStorageManager.validExtras(data)) {
                waffarAdLocalStorageManager.saveAffiliateTripExtras(data)
                waffarAdLocalStorageManager.saveShoppingTripTime()
                validTrip=  true
            }
            }

        return validTrip
    }


    fun postbackAffiliateOrder(context: Context,body: Any? ,  waffarAdPostBack: WaffarAdPostBack):Boolean{
        val waffarAdLocalStorageManager = WaffarAdLocalStorageManager(context)
        val savingTime = waffarAdLocalStorageManager.getShoppingTripTime()
        val data = waffarAdLocalStorageManager.retrieveAffiliateTripParams()
        val diff :Long = System.currentTimeMillis() - savingTime
        if( data == null){
            return false
        }
        // make sure that the time in this month
        if( diff / 1000 <= 30 * 60 * 60 * 24 ){
            //Todo call API
           val params=  waffarAdLocalStorageManager.retrieveAffiliateTripParams()
            val af_id: String? = params?.get(waffarAdLocalStorageManager.AFID);
            val sub_id = params?.get(waffarAdLocalStorageManager.SUBID);
            WaffarAdAPIManager.postback(af_id,sub_id,body,waffarAdPostBack)
            return true
        }
        else{
            waffarAdLocalStorageManager.clearLocalStorage()
            return false
        }


    }
    fun _postbackShoppingTrip(){

    }
}
