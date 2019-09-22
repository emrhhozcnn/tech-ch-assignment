package com.eozcan.techchassignment.viewmodels

import androidx.databinding.BaseObservable
import com.eozcan.techchassignment.adapters.OrderClickListener
import com.eozcan.techchassignment.models.Order

class OrderItemViewModel(val order: Order, val orderClickListener: OrderClickListener, val position:Int) : BaseObservable() {

    fun onItemClicked() {
        orderClickListener.onItemClicked(position)
    }
}