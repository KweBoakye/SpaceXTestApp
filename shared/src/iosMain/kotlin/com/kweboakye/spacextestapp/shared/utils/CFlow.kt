package com.kweboakye.spacextestapp.shared.utils

import io.ktor.utils.io.core.Closeable
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class CFlow<T>(private val origin: Flow<T>) {

    fun watch(block: (T) -> Unit): Closeable {
        val job = Job()

        origin.onEach { element ->
            block(element)
        }

        return object : Closeable {
            override fun close() {
                job.cancel()
            }
        }
    }
}

fun <T> Flow<T>.toCFlow(): CFlow<T> = CFlow(this)
