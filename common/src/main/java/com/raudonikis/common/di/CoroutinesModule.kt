package com.raudonikis.common.di

import com.raudonikis.common.coroutines.CoroutineDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

/**
 * Dagger module for coroutines dependencies
 */
@Module
@InstallIn(SingletonComponent::class)
object CoroutinesModule {

    @Provides
    fun provideCoroutineDispatcherProvider(): CoroutineDispatcherProvider {
        return CoroutineDispatcherProvider(
            ioDispatcher = Dispatchers.IO,
            mainDispatcher = Dispatchers.Main,
            defaultDispatcher = Dispatchers.Default
        )
    }
}