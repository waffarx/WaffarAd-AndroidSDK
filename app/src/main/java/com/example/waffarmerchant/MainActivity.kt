package com.example.waffarmerchant

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import java.net.URI

import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.waffarad.android.ShoppingTrip
import com.waffarad.android.WaffarAdAffiliateManager
import com.waffarad.android.WaffarAdPostBack

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val textView: TextView = findViewById(R.id.textView) as TextView
        Toast.makeText(this, "Mustafa Gamal", Toast.LENGTH_SHORT).show()

        receiveWaffarAdParams(intent)
        val res = WaffarAdAffiliateManager.trackAffiliateTrip(this, intent)
        Toast.makeText(this, "Mustafa Gasd asdasd amal:" + res.toString(), Toast.LENGTH_SHORT)
            .show()
        if (res) {
            WaffarAdAffiliateManager.postbackAffiliateOrder(
                this,
                ShoppingTrip(12, 45, "sd", "sgf"),
                object : WaffarAdPostBack {
                    override fun onSuccess() {
                        Toast.makeText(applicationContext, "CashBack : ", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFail() {

                    }
                })
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun receiveWaffarAdParams(intent: Intent) {
        val action: String? = intent?.action
        val data: Uri? = intent?.data
        val extras: Bundle? = intent?.extras
        // val sharedPreferences: SharedPreferences = this.getSharedPreferences(  "WAFFARAD_PREFERENCE", )
        Toast.makeText(
            this,
            data?.host.toString() + " Extra: " + extras?.get("STRING").toString(),
            Toast.LENGTH_SHORT
        ).show()

        if (data?.getQueryParameter("piso") != null) {
            print(data.getQueryParameter("piso"))
            Toast.makeText(this, data.getQueryParameter("piso"), Toast.LENGTH_SHORT).show()
        } else {

        }
    }
}