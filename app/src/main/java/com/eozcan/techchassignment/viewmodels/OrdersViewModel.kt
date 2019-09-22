package com.eozcan.techchassignment.viewmodels

import androidx.databinding.BaseObservable
import com.eozcan.techchassignment.adapters.OrdersAdapter
import com.eozcan.techchassignment.models.Order
import com.eozcan.techchassignment.network.NetworkClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrdersViewModel(val ordersPageListener: OrdersPageListener) : BaseObservable() {
    val adapter = OrdersAdapter()

    init {
        NetworkClient.getService().getOrderList().enqueue(object : Callback<List<Order>> {
            override fun onResponse(call: Call<List<Order>>, response: Response<List<Order>>) {
                adapter.orderList = response.body() as ArrayList<Order>
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Order>>, t: Throwable) {
                // TODO
            }
        })
    }

    fun onExitButtonClicked() {
        ordersPageListener.onExitPageClicked()
    }
}

interface OrdersPageListener {
    fun onExitPageClicked()
}