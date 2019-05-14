/*
 *
 * Developed by Shudipto Trafder.
 * On 1/22/19 9:36 PM
 * Copyright (c)Shudipto Trafder.
 */

package com.iamsdt.androidextension

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import es.dmoral.toasty.Toasty

enum class ToastType {
    INFO,
    ERROR,
    SUCCESSFUL,
    WARNING
}

fun AppCompatActivity.showToasty(
    message: String,
    type: ToastType = ToastType.INFO,
    time: Int = Toast.LENGTH_SHORT,
    withIcon: Boolean = true
) {

    when (type) {
        ToastType.INFO -> Toasty.info(this, message, time, withIcon).show()
        ToastType.ERROR -> Toasty.error(this, message, time, withIcon).show()
        ToastType.SUCCESSFUL -> Toasty.success(this, message, time, withIcon).show()
        ToastType.WARNING -> Toasty.warning(this, message, time, withIcon).show()
    }
}

fun Fragment.showToasty(
    message: String,
    type: ToastType = ToastType.INFO,
    time: Int = Toast.LENGTH_SHORT,
    withIcon: Boolean = true
) {

    when (type) {
        ToastType.INFO -> Toasty.info(context!!, message, time, withIcon).show()
        ToastType.ERROR -> Toasty.error(context!!, message, time, withIcon).show()
        ToastType.SUCCESSFUL -> Toasty.success(context!!, message, time, withIcon).show()
        ToastType.WARNING -> Toasty.warning(context!!, message, time, withIcon).show()
    }
}

fun AppCompatActivity.showToast(
    message: String,
    time: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(this, message, time).show()
}

fun Fragment.showToast(
    message: String,
    time: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(context, message, time).show()
}