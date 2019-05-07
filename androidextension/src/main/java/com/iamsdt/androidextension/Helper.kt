package com.iamsdt.androidextension

import android.os.AsyncTask
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun bcgThread(f: () -> Unit) {
    AsyncTask.execute(f)
}

fun ioThread(f: () -> Unit) {
    GlobalScope.launch(Dispatchers.IO) { f() }
}