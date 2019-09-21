package com.eozcan.techchassignment.viewmodels

import androidx.databinding.BaseObservable
import com.eozcan.techchassignment.adapters.OrdersAdapter

class OrdersViewModel : BaseObservable() {
    val adapter = OrdersAdapter()

}