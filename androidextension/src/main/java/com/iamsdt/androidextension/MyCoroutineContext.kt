/*
 *
 * Developed by Shudipto Trafder.
 * On 4/11/19 10:18 PM
 * Copyright (c)Shudipto Trafder.
 */

package com.iamsdt.androidextension

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

open class MyCoroutineContext : CoroutineScope, LifecycleObserver {

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun destroy() = coroutineContext.cancelChildren()

}