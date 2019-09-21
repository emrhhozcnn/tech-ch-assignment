package com.eozcan.techchassignment.network

import com.eozcan.techchassignment.models.Order
import retrofit2.http.GET
import retrofit2.Call


interface AssignmentNetworkService {
    @GET("/")
    fun getOrderList():Call<List<Order>>
}