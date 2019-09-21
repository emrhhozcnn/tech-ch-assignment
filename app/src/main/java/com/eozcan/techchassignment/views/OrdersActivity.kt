package com.eozcan.techchassignment.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.eozcan.techchassignment.R
import com.eozcan.techchassignment.databinding.ActivityOrdersBinding
import com.eozcan.techchassignment.viewmodels.OrdersViewModel

class OrdersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)

        val binding =
            DataBindingUtil.setContentView<ActivityOrdersBinding>(this, R.layout.activity_orders)
        binding.viewModel = OrdersViewModel()
    }
}