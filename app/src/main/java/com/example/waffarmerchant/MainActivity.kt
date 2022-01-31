package com.example.waffarmerchant

import Order
import android.content.Intent
import android.net.Uri
import android.os.Bundle

import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.waffarad.android.WaffarAdAffiliateManager
import com.waffarad.android.WaffarAdPostBack
import com.waffarad.android.models.*

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
        var coupons: List<Coupon> = listOf(
            Coupon(
                id = 325,
                code = "asd",
                discountedAmount = 23.90,
                displayName = "asddf"
            )
        )
        var items: List<Product> = listOf(
            Product(

                productId = 56,
                name = "ad",
                url = "asdd",
                sku = "ewrer",
                quantity = 3,
                isTaxable = true,
                salePrice = 12.55,

                extendedSalePrice = 122.3,
                imageUrl = "sadasd",
                discount =  12.4,
                listPrice = 12.4,

                extendedListPrice = 234.23,


                categories = listOf("Categ")
            )
        )

        val order = Order(
            orderId = 32143,
            cartId = "weewre",
            currency = Currency(name = "USD", code = "$", symbol = "$"),
            isTaxIncluded = false,
            baseAmount = 1233.44,
            discountAmount = 123.4,
            orderAmount = 123.5,
            orderAmountAsInteger = 123,
            shippingCostTotal = 50,
            shippingCostBeforeDiscount = 40.2,

            coupons = coupons,
            products = items,
            customerId = "12323", // TODo de Int wala String
            status = "Pending",

            taxes = listOf(Tax(name = "asdasfas",amount = 14.0)),
            totalTaxes = 234.2,

            current_page_url = "URl",
            base_url = "baseURL",
            af_id = "123",
            subid = "3423442s",
            merchant_name = "String",
            billingAddress = null,orderName = "#123456789",currencyCode = "EGY"
        )
        order.toJson() ;
        val res = WaffarAdAffiliateManager.trackAffiliateTrip(this, intent)
        Toast.makeText(this, "Mustafa Gasd asdasd amal:" + res.toString(), Toast.LENGTH_SHORT)
            .show()
        if (res) {

            WaffarAdAffiliateManager.postbackAffiliateOrder(
                this,
                order,
                object : WaffarAdPostBack {
                    override fun onSuccess() {
                        Toast.makeText(applicationContext, "CashBack : ", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFail() {
                        Toast.makeText(applicationContext, "onFail : ", Toast.LENGTH_SHORT).show()
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