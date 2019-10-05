package com.iamsdt.androidextension

import android.os.AsyncTask
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun bgThread(f: () -> Unit) {
    AsyncTask.execute(f)
}

fun ioThreadK(f: () -> Unit) {
    GlobalScope.launch(Dispatchers.IO) { f() }
}