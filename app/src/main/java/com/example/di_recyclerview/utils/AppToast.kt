package com.example.di_recyclerview.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.di_recyclerview.R

class AppToast(mContext: Context) : Toast(mContext) {
    private var mView: View? = null

    companion object {
        var LENGTH_SHORT = Toast.LENGTH_SHORT

        //normal toast
        fun toastNormal(context: Context, message: String?, duration: Int = LENGTH_SHORT) {
            val inToast = AppToast(context)
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.app_toast, null)
            val text = view.findViewById<View>(R.id.text) as TextView
            text.text = message
            inToast.duration = duration
            inToast.view = view
            inToast.mView = view
            inToast.show()
        }

        fun toastSuccess(
            context: Context,
            message: String?,
            duration: Int = LENGTH_SHORT
        ) {
            val inToast = AppToast(context)
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.app_toast, null)
            val text = view.findViewById<View>(R.id.text) as TextView
            val card = view.findViewById<View>(R.id.bg_card) as CardView
            text.setTextColor(ContextCompat.getColor(context, R.color.white))
            card.setCardBackgroundColor(ContextCompat.getColor(context, R.color.Success_Dark))
            text.text = message
            inToast.duration = duration
            inToast.view = view
            inToast.mView = view
            inToast.show()
        }

        fun toastError(
            context: Context,
            message: String?,
            duration: Int = LENGTH_SHORT
        ) {
            val inToast = AppToast(context)
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.app_toast, null)
            val text = view.findViewById<View>(R.id.text) as TextView
            val card = view.findViewById<View>(R.id.bg_card) as CardView
            text.setTextColor(ContextCompat.getColor(context, R.color.white))
            card.setCardBackgroundColor(ContextCompat.getColor(context, R.color.Alert_Dark))
            text.text = message
            inToast.duration = duration
            inToast.view = view
            inToast.mView = view
            inToast.show()
        }
    }
}