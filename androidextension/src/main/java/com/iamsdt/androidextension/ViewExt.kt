/*
 *
 * Developed by Shudipto Trafder.
 * On 1/22/19 9:30 PM
 * Copyright (c)Shudipto Trafder.
 */

package com.iamsdt.androidextension


import android.os.AsyncTask
import android.os.Build
import android.text.PrecomputedText
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.PrecomputedTextCompat
import androidx.core.widget.TextViewCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.ref.WeakReference

fun View.gone() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.inVisible() {
    visibility = View.INVISIBLE
}

fun View.changeHeight(height: Int) {
    requestLayout()
    layoutParams.height = height
}

fun View.changeWidth(width: Int) {
    requestLayout()
    layoutParams.width = width
}

fun AppCompatTextView.addTextK(string: String) {
    GlobalScope.launch(Dispatchers.Main) {
        val text = withContext(Dispatchers.IO) {
            val params = TextViewCompat.getTextMetricsParams(this@addTextK)
            PrecomputedTextCompat.create(string, params)
        }
        setPrecomputedText(text)
    }
}

fun AppCompatTextView.addText(string: String) {
    AsyncTask.execute {
        val params = TextViewCompat.getTextMetricsParams(this)
        val text = PrecomputedTextCompat.create(string, params)
        setPrecomputedText(text)
    }
}

@Deprecated("Use AppCompatTextView.addTextK() method")
fun TextView.addStrK(string: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        val params = this.textMetricsParams
        val weakReference = WeakReference(this)

        GlobalScope.launch(Dispatchers.IO) {
            val text = PrecomputedText.create(string, params)
            val textView = weakReference.get()
            textView?.post {
                val textViewRef = weakReference.get()
                textViewRef?.text = text
            }
        }

    } else {
        this.text = string
    }
}

@Deprecated("Use AppCompatTextView.addText() method")
fun TextView.addStr(string: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        val params = this.textMetricsParams
        val weakReference = WeakReference(this)

        AsyncTask.execute {
            val text = PrecomputedText.create(string, params)
            val textView = weakReference.get()
            textView?.post {
                val textViewRef = weakReference.get()
                textViewRef?.text = text
            }
        }

    } else {
        this.text = string
    }
}