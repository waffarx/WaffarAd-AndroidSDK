import com.google.gson.Gson
import com.waffarad.android.models.*

/**
 * Order class is the main object which contains all order details.
 *
 * @property orderId  order id.
 * @property orderName order id if contains string if not send the order id as string .
 * @property currencyCode order currency code like(EGP, USD).
 * @property baseAmount net order after excluding discount, tax, and shipping.
 * @property orderAmount total order amount
 * @property discountAmount total discount in order
 * @property orderAmountAsInteger total order *100 example: if orderAmount = 100.5 then orderAmountAsInteger = 10050
 * @property shippingCostTotal total shipping on order
 * @property shippingCostBeforeDiscount total shipping on order excluding the discount
 * @property taxes list of taxes applied on order.
 * @property totalTaxes total of taxes on order
 * @property merchant_name Your Company name.
 * @property cartId cart id.
 * @property currency currency details.
 * @property isTaxIncluded flag if order total including taxes or not
 * @property coupons list of coupons applied on order.
 * @property products list of order products.
 * @property customerId customer Id.
 * @property billingAddress user billing address.
 * @property status current order status like(Pending, Processing)
 * @property existingCustomer flag if the customer is new customer who has on orders before.
 * @property current_page_url  thank you or confirmed page url.
 * @property base_url company website url.
 * @property af_id your company id in WaffarAd, note: this property is handled by the SDK.
 * @property subid tracking id, note: this property is handled by the SDK.
 */
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
