package com.example.di_recyclerview.utils

import android.content.Context

fun Context.toastSuccess(msg: String, duration: Int = AppToast.LENGTH_SHORT) {
    AppToast.toastSuccess(this, msg, duration)
}

fun Context.toastError(msg: String, duration: Int = AppToast.LENGTH_SHORT) {
    AppToast.toastError(this, msg, duration)
}

fun Context.toast(msg: String, duration: Int = AppToast.LENGTH_SHORT) {
    AppToast.toastNormal(this, msg, duration)
}