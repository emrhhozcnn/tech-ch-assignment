package com.eozcan.techchassignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eozcan.techchassignment.R
import com.eozcan.techchassignment.databinding.RowItemOrderBinding
import com.eozcan.techchassignment.models.Order
import com.eozcan.techchassignment.viewmodels.OrderItemViewModel
import java.text.DateFormatSymbols

class OrdersAdapter : RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>(), OrderClickListener {
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
        holder.setViewModel(OrderItemViewModel(orderList[position], this, position))
    }

    override fun onViewDetachedFromWindow(holder: OrderViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.unBind()
    }

    override fun onViewAttachedToWindow(holder: OrderViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.bind()
    }

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: RowItemOrderBinding? = null

        init {
            bind()
        }

        fun bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind<RowItemOrderBinding>(itemView)!!
            }
        }

        fun unBind() {
            binding?.unbind()
        }

        fun setViewModel(viewModel: OrderItemViewModel) {
            binding?.viewModel = viewModel
        }
    }

    override fun onItemClicked(position: Int) {
        orderList[position].productExpanded = !orderList[position].productExpanded
        notifyDataSetChanged()
    }

    companion object {
        // BE'den gelen veri string olduğu ve veri niteliği taşıdığı için string.xml'e yazmayıp
        // buraya yazdım.
        private val containerToOrderStatusText = mapOf(
            R.id.container_order_status_preparing to "Hazırlanıyor",
            R.id.container_order_status_order_on_way to "Yolda",
            R.id.container_order_status_waiting to "Onay Bekliyor"
        )

        @BindingAdapter("status")
        @JvmStatic
        fun setOrderStatus(container: View, status: String) {
            val statusText = containerToOrderStatusText[container.id]
            if (statusText != null && statusText.equals(status)) {
                container.visibility = View.VISIBLE
            } else {
                container.visibility = View.GONE
            }
        }

        @BindingAdapter("month")
        @JvmStatic
        fun setMonthName(textView: TextView, month: String) {
            textView.text = DateFormatSymbols().months[month.toInt() - 1]
        }

        @BindingAdapter("price")
        @JvmStatic
        fun setPrice(textView: TextView, price: Double) {
            textView.text = price.toString() + "TL"
        }

        @BindingAdapter("expanded")
        @JvmStatic
        fun setExpanded(productDetailView: View, expanded: Boolean) {
            productDetailView.visibility = if (expanded) View.VISIBLE else View.GONE
        }
    }
}

// Sipariş tıklandığında expand etmek için gerekli interface
interface OrderClickListener {
    fun onItemClicked(position: Int)
}
