import com.google.gson.Gson
import com.waffarad.android.models.*


data class  Order(
    val orderId: Int,
    val orderName: String,
    val currencyCode: String,
    val baseAmount: Double,
    val orderAmount: Double,
    val discountAmount: Double,
    val orderAmountAsInteger: Int,
    val shippingCostTotal: Int,
    val shippingCostBeforeDiscount: Double,
    val taxes: List<Tax>?= listOf(),
    val totalTaxes: Double? = 0.0,
    var merchant_name: String? ="",
    val cartId: String? ="",
    val currency: Currency? = null,
    val isTaxIncluded: Boolean?= false,
    val coupons: List<Coupon>? =listOf(),
    val products: List<Product>? = listOf(),
    val customerId: String?="",
    val billingAddress: BillingAddress?= null,
    val status: String?="",
    val existingCustomer :Boolean = false,

    val current_page_url: String?="",
    val base_url: String?="",
    var af_id: String?="",
    var subid: String?=""
){

    fun toJson (){
        val gson = Gson()
        var mUser = gson.toJson( this)
        println(mUser.toString())
    }
}
