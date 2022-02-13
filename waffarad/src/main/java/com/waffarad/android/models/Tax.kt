package com.waffarad.android.models

/**
 * Tax is the total tax on order total.
 * @property name order tax.
 * @property amount order tax amount.
 */
class Tax constructor(val name: String?="",
                      val amount: Double?=0.0)