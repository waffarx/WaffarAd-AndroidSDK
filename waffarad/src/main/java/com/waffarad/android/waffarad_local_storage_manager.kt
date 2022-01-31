package com.waffarad.android

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle


class WaffarAdLocalStorageManager(_context: Context) {

    val AFID:String ="af_id"
    val SUBID:String ="subid"
    val SHOPPING_TIME:String ="shopping_time"
    val context = _context

    val sharedPreferences: SharedPreferences = context.getSharedPreferences("WAFFARAD_LOCAL_STORAGE", Context.MODE_PRIVATE)

    fun  validParams(uri: Uri?): Boolean{
        return  (uri?.getQueryParameter(AFID)!=null) //&&(uri.getQueryParameter(SUBID)!=null)
    }
    fun  validExtras(bundle: Bundle?): Boolean{
        return  (bundle?.get(AFID)!=null)// &&(bundle.get(SUBID)!=null)
    }
    fun saveAffiliateTripParams(uri:Uri?){
        val editor: SharedPreferences.Editor =  sharedPreferences.edit()
        editor.putString(AFID, uri?.getQueryParameter(AFID))
        editor.putString(SUBID, uri?.getQueryParameter(SUBID))
        editor.apply()
    }
    fun saveAffiliateTripExtras(bundle: Bundle?){
        val editor: SharedPreferences.Editor =  sharedPreferences.edit()
        editor.putString(AFID, bundle?.get(AFID).toString())
        editor.putString(SUBID, bundle?.get(SUBID).toString())
        editor.apply()
    }
    fun saveShoppingTripTime(){
        val editor: SharedPreferences.Editor =  sharedPreferences.edit()
        editor.putLong(SHOPPING_TIME,  System.currentTimeMillis())
        editor.apply()
    }
    fun retrieveAffiliateTripParams() :Map<String, String>? {
        val Af_id: String? =  sharedPreferences.getString(AFID, null)
        val subId: String? =  sharedPreferences.getString(SUBID, null)
        if(Af_id == null //||subId == null
        )
            return null
        return  mapOf(AFID to "$Af_id", SUBID to "$subId")
    }
    fun getShoppingTripTime():Long{
        return sharedPreferences.getLong(SHOPPING_TIME, 0)
    }

    fun clearLocalStorage(){
        val editor: SharedPreferences.Editor =  sharedPreferences.edit()
        editor.apply()
        editor.apply()
    }


}

