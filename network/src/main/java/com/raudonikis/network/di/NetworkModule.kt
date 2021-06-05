package com.raudonikis.network.di

import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import com.raudonikis.network.AuthenticationApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideAuthenticationApi(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): AuthenticationApi {
        return Retrofit.Builder()
            .baseUrl(AuthenticationApi.baseUrl)
            .client(okHttpClient)
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(moshiConverterFactory)
            .build()
            .create(AuthenticationApi::class.java)
    }

    @Provides
    internal fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}