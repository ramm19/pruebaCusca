package com.ramm.pruebacuscatlan.framework.di

import com.google.gson.GsonBuilder
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import com.ramm.pruebacuscatlan.BuildConfig
import com.ramm.pruebacuscatlan.framework.service.PostService
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create() }
    single { GsonConverterFactory.create() as Converter.Factory }

    single(named("connect")) {
        OkHttpClient
            .Builder().apply {
                if (BuildConfig.DEBUG){
                    addInterceptor(OkHttpProfilerInterceptor())
                        .callTimeout(90L, TimeUnit.SECONDS)
                }
            }
            .readTimeout(90L, TimeUnit.SECONDS)
            .connectTimeout(90L, TimeUnit.SECONDS)
            .build()
    }

    single(named("api")) {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(get(named("connect")))
            .addConverterFactory(get())
            .build()
    }

    single { get<Retrofit>(named("api")).create(PostService::class.java) }
}