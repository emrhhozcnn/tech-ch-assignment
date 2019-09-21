package com.eozcan.techchassignment.utils

import android.app.AlertDialog
import android.content.Context


class AlertUtil {
    companion object {
        fun showAlert(
            context: Context,
            title: Int,
            message: Int,
            btnText: Int
        ) {
            showAlertWithOptions(context, title, message, null, null, btnText)
        }

        fun showAlertWithOptions(
            context: Context,
            title: Int,
            message: Int,
            positiveBtnText: Int?,
            positiveBtnAction: Runnable?,
            negativeBtnText: Int
        ) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle(context.getString(title))
            builder.setMessage(context.getString(message))
            if (positiveBtnText != null) {
                builder.setPositiveButton(
                    context.getString(positiveBtnText)
                ) { _, _ ->
                    positiveBtnAction?.run()
                }
            }
            builder.setNegativeButton(context.getString(negativeBtnText), null)

            builder.show()
        }
    }
}