package com.eozcan.techchassignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eozcan.techchassignment.R
import com.eozcan.techchassignment.models.Order

class OrdersAdapter : RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>() {
    var orderList = ArrayList<Order>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(
            R.layout.row_item_order,
            parent, false
        )
        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        // TODO
    }

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}