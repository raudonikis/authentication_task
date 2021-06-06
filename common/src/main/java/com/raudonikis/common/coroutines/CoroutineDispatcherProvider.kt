package com.raudonikis.common.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Provides different dispatchers for coroutine usage
 */
class CoroutineDispatcherProvider constructor(
    val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    val mainDispatcher: CoroutineDispatcher = Dispatchers.Main,
    val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default,
)