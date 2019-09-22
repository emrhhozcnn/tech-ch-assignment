package com.eozcan.techchassignment.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.eozcan.techchassignment.R
import com.eozcan.techchassignment.constants.Params
import com.eozcan.techchassignment.databinding.ActivityOrdersBinding
import com.eozcan.techchassignment.utils.AlertUtil
import com.eozcan.techchassignment.utils.SharedPreferencesUtil
import com.eozcan.techchassignment.viewmodels.OrdersPageListener
import com.eozcan.techchassignment.viewmodels.OrdersViewModel

class OrdersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)

        val binding =
            DataBindingUtil.setContentView<ActivityOrdersBinding>(this, R.layout.activity_orders)
        binding.viewModel = OrdersViewModel(object : OrdersPageListener {
            override fun onExitPageClicked() {
                AlertUtil.showAlertWithOptions(
                    this@OrdersActivity,
                    R.string.app_name,
                    R.string.exit_message,
                    R.string.i_want,
                    Runnable {
                        // Beni hatırla değişkenini false a çek
                        SharedPreferencesUtil.setBoolean(
                            this@OrdersActivity,
                            Params.KEY_REMEMBER_ME,
                            false
                        )
                        // Login sayfasını aç
                        val intent = Intent(this@OrdersActivity, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    },
                    R.string.i_dont_want
                )
            }
        })
    }
}