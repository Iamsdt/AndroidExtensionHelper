/*
 *
 * Developed by Shudipto Trafder.
 * On 1/22/19 9:38 PM
 * Copyright (c)Shudipto Trafder.
 */

package com.iamsdt.androidextension

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Thread.sleep
import kotlin.concurrent.thread

inline fun <reified T : AppCompatActivity> AppCompatActivity.nextActivity(
    extraKey: String = "", extra: Any = "", finish: Boolean = false,
    list: Map<String, Any> = emptyMap()
) {

    val intent = Intent(this, T::class.java)

    if (extraKey.isNotEmpty()) {
        when (extra) {
            is String -> intent.putExtra(extraKey, extra)
            is Boolean -> intent.putExtra(extraKey, extra)
            is Float -> intent.putExtra(extraKey, extra)
            is Long -> intent.putExtra(extraKey, extra)
            is Int -> intent.putExtra(extraKey, extra)
            is Bundle -> intent.putExtra(extraKey, extra)
            else -> intent.putExtra(extraKey, "$extra")
        }
    }

    if (list.isNotEmpty()) {
        list.forEach {
            when (val extras = it.value) {
                is String -> intent.putExtra(it.key, extras)
                is Boolean -> intent.putExtra(it.key, extras)
                is Float -> intent.putExtra(it.key, extras)
                is Long -> intent.putExtra(it.key, extras)
                is Int -> intent.putExtra(it.key, extras)
                is Bundle -> intent.putExtra(it.key, extras)
                else -> intent.putExtra(it.key, "$extras")
            }
        }
    }

    startActivity(intent)

    if (finish) finish()
}

inline fun <reified T : AppCompatActivity> AppCompatActivity.runThread(timer: Long = 1000) {
    thread(priority = 10) {
        sleep(timer)
        nextActivity<T>()
        finish()
    }
}

inline fun <reified T : AppCompatActivity> AppCompatActivity.runThreadK(timer: Long = 1000) {
    GlobalScope.launch {
        delay(timer)
        nextActivity<T>(finish = true)
    }
}

inline fun <reified T : AppCompatActivity> Fragment.nextActivity(
    extraKey: String = "", extra: Any = "", list: Map<String, Any> = emptyMap()
) {
    val intent = Intent(activity, T::class.java)

    if (extraKey.isNotEmpty()) {
        when (extra) {
            is String -> intent.putExtra(extraKey, extra)
            is Boolean -> intent.putExtra(extraKey, extra)
            is Float -> intent.putExtra(extraKey, extra)
            is Long -> intent.putExtra(extraKey, extra)
            is Int -> intent.putExtra(extraKey, extra)
            is Bundle -> intent.putExtra(extraKey, extra)
            else -> intent.putExtra(extraKey, "$extra")
        }
    }

    if (list.isNotEmpty()) {
        list.forEach {
            when (val extras = it.value) {
                is String -> intent.putExtra(it.key, extras)
                is Boolean -> intent.putExtra(it.key, extras)
                is Float -> intent.putExtra(it.key, extras)
                is Long -> intent.putExtra(it.key, extras)
                is Int -> intent.putExtra(it.key, extras)
                is Bundle -> intent.putExtra(it.key, extras)
                else -> intent.putExtra(it.key, "$extras")
            }
        }
    }

    startActivity(intent)
}

fun AppCompatActivity.sendEmail(
    email: String,
    subject: String
) {

    val intent = Intent(Intent.ACTION_SENDTO)
    intent.type = "text/plain"
    intent.data = Uri.parse("mailto:$email")
    intent.putExtra(Intent.EXTRA_SUBJECT, subject)
    startActivity(Intent.createChooser(intent, "Send Email"))
}


