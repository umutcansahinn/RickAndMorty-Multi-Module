package com.umutcansahin.feature.util

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

fun <T> Fragment.collectFlow(
    flow: Flow<T>,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    lifecycle: Lifecycle = viewLifecycleOwner.lifecycle,
    action: suspend (T) -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch {
        flow.flowWithLifecycle(lifecycle, state).collect {
            action(it)
        }
    }
}
/*
fun <T> Fragment.collectFlow2(
    flow: Flow<T>,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    action: suspend (T) -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.repeatOnLifecycle(state) {
            flow.collect {
                action(it)
            }
        }
    }
}*/