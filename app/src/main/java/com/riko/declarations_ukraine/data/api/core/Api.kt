package com.riko.declarations_ukraine.data.api.core

import com.riko.declarations_ukraine.BuildConfig
import com.riko.declarations_ukraine.data.api.NazkApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Roman on 10.07.2017
 */
class Api {
    private val BASE_URL = "https://public-api.nazk.gov.ua/"
    private val requests: Requests
    var nazkApi: NazkApi

    init {
        val okHttpClient = OkHttpClient().newBuilder()
                .readTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .addInterceptor(httpLoggingInterceptor)
                .build()

        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .build()

        requests = retrofit.create(Requests::class.java)
        nazkApi = NazkApi(requests)
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////// INTERCEPTORS /////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private val httpLoggingInterceptor: HttpLoggingInterceptor
        get() {
            val logging = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                logging.level = HttpLoggingInterceptor.Level.BODY
            } else {
                logging.level = HttpLoggingInterceptor.Level.NONE
            }
            return logging
        }
}