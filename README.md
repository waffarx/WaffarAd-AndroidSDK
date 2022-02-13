# WaffarAd-AndroidSDK

### Index 
* [What is WaffarAd solution](#waffarad)
* [Android-SDK](#android-sdk)
* [Features](#features)
* [Prerequisites](#prerequisites)
* [Usage](#usage)
* [Notes](#notes)
* [License](#license)

## WaffarAd  
 WaffarAd is an affiliate network and platform that acts as a middle man between publishers (affiliates) and advertisers (merchants). Advertisers establish their affiliate programs on an affiliate network and publishers can search the network to find programs that they want to promote. The affiliate network acts as a manager for both publishers and advertisers.

## Android SDK
WaffarAd-AndroidSDK is the android solution for android developers to establish an affiliate program on their applications. You can use this SDK for Web applications and/or mobile applications.
 
## Features
* Receiving the affiliated shopping trip.
* Post-back the order to the affiliate network. 


## Prerequisites

* **Add dependencies**  

Add the library dependency in your app-level build.gradle file 
```gradle
dependencies {
              ...
     implementation 'com.github.waffarx:WaffarAd-AndroidSDK:1.1'
}
```
Add jitpack.io to your project-level build.gradle file  :
```gradle
allprojects {
  		repositories {
  			```
  			maven { url 'https://jitpack.io' }
  		}
  	}
```
### [Optional] if you only have a mobile application 
## How to define intent filters

When we talk about handling how to navigate users directly to your applications, we should think about adding an intent filter in our manifest file. 
An intent filter should contain the following elements and attribute values;

1. Define `ACTION_VIEW` intent action so that the intent filter can be reached from Google Search or redirected form another app.
```xml
<action android:name="android.intent.action.VIEW" />
```
2. We should include the `BROWSABLE` category in order to be accessible from a web browser. We should also have a DEFAULT category for responding to implicit intents
```xml
<category android:name="android.intent.category.DEFAULT" />
<category android:name="android.intent.category.BROWSABLE" />
```

3. Lastly, we should define one or more <data> tags. Each of these tags represents a URI format that resolves to the activity. The following example represents a simple data tag for example.com Android app.
```xml
<data
    android:scheme="https"
    
    android:host="example.com"
    />
```    
## The Whole Parts of Deep Linking Intent Filter 
```xml
 <intent-filter>
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />
                <data
                    android:scheme="https"
                    android:host="example.com"
                      />
   </intent-filter>
```
 
  

## Usage
### Receiving Shopping Trips
> Place this line in your `onCreate` in your main acitivty. 
```kotlin
       val result = WaffarAdAffiliateManager.trackAffiliateTrip(this, intent)
```
	
`result` contains a boolean that indicates if the shopping trip is valid to track or not. 
	
### Check if there is affiliate order

```kotlin
  WaffarAdAffiliateManager.isAffiliateOrder(this); // this: Context 
```
	
### Post-back the order to the affiliate network to let the user get cashback
> Place the following after the user places his/her order successfully. 

 
```kotlin
	 WaffarAdAffiliateManager.postbackAffiliateOrder(
                this,// Context 
                Order(), 
                object : WaffarAdPostBack {
                    override fun onSuccess() {
                      // TODO handle the meessage this tells users that you get the cashback on their orders.
                    }
                    override fun onFail() {
                         // TODO  failed to get a cash back. 
                    }
                })
```

---------------
	
### Order Object 
 
> **Order class is the main object which contains all order details.**
#### @properties
| Name | Type           | Description                            |
|-----------|----------------|----------------------------------------|
| `orderId`  | Int   | Order id.                      |
| `orderName`| String | Flag if request processed successfully |
| `currencyCode`|  String | Order currency code like(EGP, US). |
| `baseAmount` | Double| Net order after excluding discount, tax, and shipping.|
| `orderAmount`| Double | Total order amount|
| `discountAmount`| Double |Total discount in order|
| `orderAmountAsInteger`| Int | Total order *100 example: if orderAmount = 100.5 then orderAmountAsInteger = 10050|
| `shippingCostTotal` | Int| Total shipping on order |
| `shippingCostBeforeDiscount`| Double | Total shipping on order excluding the discount.|
| `taxes`| List<[Tax](#tax-object)>? | List of taxes applied on order.|
| `totalTaxes`| Double? | Total of taxes on order  |
| `merchant_name`| String?  | Your Company name. |
| `cartId`| String?| Cart id.|
| `currency`| [Currency](#currency-object)?  | Currency details.|
| `isTaxIncluded`| Boolean | Flag if order total including taxes or not|
| `coupons`| List<[Coupon](#coupon-object)>? | List of coupons applied on order. |
| `products`| List<[Product](#product-object)>?| List of order products. |
| `customerId`| String? | Customer Id. |
| `billingAddress`| [BillingAddress](#billingaddress-object)? | User billing address. |
| `status`| String? | Current order status like(Pending, Processing) |
| `existingCustomer`| Boolean|Flag if the customer is new customer who has on orders before.|
| `current_page_url`| String?|Thank you or confirmed page url.|
| `base_url`| String?| Company website url.|
 
### Product Object 
> **Product is the total tax on order total.**

#### @properties
| Name | Type           | Description                            |
|-----------|----------------|----------------------------------------|
| `productId`  | Int   |Product Id.|
| `name`| String | Product name.|
| `quantity`  | Int   |Quantity of product in the order.|
| `discount`  | Double |Total discount of total quantity.|
| `salePrice`  | Double   |Price after sale.|
| `listPrice`  | Double  |Original price.|
| `url`  | String   |Product Url.|
| `sku`  | String  |Product sku.|
| `isTaxable`  | Boolean   |Flag if the product include taxes.|
| `imageUrl`  | String |Product image in website.|
| `categories`  | List<String>?  |List of product category names.|
	
### Tax Object 
 
> **Tax is the total tax on order total.**
#### @properties
| Name | Type           | Description                            |
|-----------|----------------|----------------------------------------|
| `name`  | String   |Order tax.  |
| `amount`| Double | Order tax amount.|
 

### Coupon Object 
 
> **Coupon is the applied coupon in order.**
#### @properties
| Name | Type           | Description                            |
|-----------|----------------|----------------------------------------|
| `id`  | Int   |Coupon id.|
| `code`| String | coupon code.|
| `discountedAmount`  | Double   |Discounted amount in total order.|
| `displayedName`| String | Coupon display name.|
 
	
### Currency Object 
> **Currency class is thee order's currency.**
#### @properties
| Name | Type           | Description                            |
|-----------|----------------|----------------------------------------|
| `name`  | String   |Currency name.|
| `code`| String | Currency code.|
| `symbol`  | String   |Currency symbol.|
 
 	
	 
### BillingAddress Object 
> **BillingAddress is user billing address.**
#### @properties
| Name | Type           | Description                            |
|-----------|----------------|----------------------------------------|
| `firstName`  | String   |User first name.|
| `lastName`| String | User last name,|
| `email`  | String   |User email.|
| `phone`  | String |User phone.|
| `company`  | String   |User company.|
| `address1`  | String  |User address.|
| `address2`  | String   |Another user address.|
| `city`  | String  |User city.|
| `stateOrProvince`  | String   |User state or province.|
| `stateOrProvinceCode`  | String |User state or province code.|
| `country`  | String  |User country.|
| `countryCode`  | String |User country code.|
| `postalCode`  | String  |User postal code.|


## Notes
 The received shopping trip params will be valid for 30 days only. 
## License
--------

    Copyright 2021 WarrarX <app@waffarx.com>.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
