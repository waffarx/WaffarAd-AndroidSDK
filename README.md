# WaffarAd-AndroidSDK

### Index 
* [What is WaffarAd solution](#WaffarAd)
* [Android-SDK](#Android-SDK)
* [Features](#features)
* [Prerequisites](#prerequisites)
* [Usage](#usage)
* [Notes](#notes)
* [License](#license)

## WaffarAd  
 WaffarAd is an affiliate network is platform that act as a middle man between the publisher (the affiliate) and the advertiser (the merchant). 
 Advertisers establish their affiliate programs on an affiliate network and publishers can search the network to find programs that they want to promote. 
 The affiliate network acts as a manager for both publishers and advertisers.

## Android-SDK
 WaffarAd-AndroidSDK is the android solution for android developers to establish the affiliate program on thier applications.
 You can use this SDK either you have Web appication and mobile application or mobile application ONLY. 
 
## Features
* Recieving the affiliated shopping trip. 
* Post-back the order to the affiliate network. 


## Prerequisites

* **Add dependencies**  

Add the library dependency in your app-level build.gradle file 
```gradle
dependencies {
              ...
     implementation 'com.github.waffarx:WaffarAd-AndroidSDK:1.0'
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
### (Optional) if you have only mobile application. 
## How to define intent filters

When we talk about handling how to navigate users directly to you applications, we should think about adding an intent filter in our manifest file.
An intent filter should contain the following elements and attribute values;

1. Define `ACTION_VIEW` intent action so that the intent filter can be reached from Google Search or redirection form another app.
```xml
<action android:name="android.intent.action.VIEW" />
```
2. We should include the `BROWSABLE` category in order to be accessible from a web browser. We should also have DEFAULT category for responding to implicit intents
```xml
<category android:name="android.intent.category.DEFAULT" />
<category android:name="android.intent.category.BROWSABLE" />
```

3. Lastly, We should define one or more <data> tags. Each of these tags represents a URI format that resolves to the activity. The following example represents a simple data tag for example.com Android app.
```xml
<data
    android:scheme="https"
    
    android:host="example.com"
    />
```    
## The whole parts of deep linking intent filter. 
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
### Recieving Shopping trips
place this line in your `onCreate` in your main acitivty. 
```kotlin
       val result = WaffarAdAffiliateManager.trackAffiliateTrip(this, intent)
```
`result` contains a boolean that indicates if the shopping trip is valid to track or not. 

### Post-back the order to the affiliate network, to make the user get the cashback 
Place the following after the user place his/her order successfully. 

 
```kotlin
	 WaffarAdAffiliateManager.postbackAffiliateOrder(
                this,// Context 
                YourCustomObject(),
                object : WaffarAdPostBack {
                    override fun onSuccess() {
                      // TODO handle the meessage this tells users that you get the cashback on their orders.
                    }
                    override fun onFail() {
                         // TODO  failed to get a cash back. 
                    }
                })
```
 
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
