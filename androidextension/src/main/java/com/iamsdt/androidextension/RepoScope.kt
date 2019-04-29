/*
 *
 * Developed by Shudipto Trafder.
 * On 4/12/19 10:09 PM
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

open class RepoScope : LifecycleObserver {

    private val job = SupervisorJob()
    protected val uiScope =
        CoroutineScope(Dispatchers.Main + job)

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() = uiScope.coroutineContext.cancelChildren()

}