package com.eozcan.techchassignment.models

data class Order(
    val date: String,
    val month: String,
    val marketName: String,
    val orderName: String,
    val productPrice: Double,
    val productState: String,
    val productDetail: ProductDetail,
    var productExpanded: Boolean = false
)