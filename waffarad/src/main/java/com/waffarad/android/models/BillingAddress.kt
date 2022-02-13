package com.waffarad.android.models

/**
 * BillingAddress is user billing address.
 * @property firstName  user first name.
 * @property lastName user last name
 * @property email user email.
 * @property company user company.
 * @property address1 user address.
 * @property address2 another user address.
 * @property city user city.
 * @property stateOrProvince user state or province.
 * @property stateOrProvinceCode user state or province code.
 * @property country user country.
 * @property countryCode user country code
 * @property postalCode user postal code.
 * @property phone user phone.
 */

data class BillingAddress(
    val  firstName : String?  = "" ,
    val  lastName : String?  = "" ,
    val  email : String?  = "" ,
    val  company : String?  = "" ,
    val  address1 : String?  = "" ,
    val  address2 : String? = "" ,
    val  city : String? = "" ,
    val  stateOrProvince : String? = "" ,
    val  stateOrProvinceCode : String? = "" ,
    val  country : String? = "" ,
    val  countryCode : String? = "" ,
    val  postalCode : String? = "" ,
    val  phone : String?= ""
)

