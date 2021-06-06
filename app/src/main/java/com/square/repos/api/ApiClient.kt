package com.square.repos.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private const val baseUrl = "https://api.github.com/"
    private var retrofit: Retrofit? = null
    private var apiInterface: ApiInterface? = null

    fun getApiInterface(): ApiInterface {
        if (apiInterface == null) {
            apiInterface = getClient().create(ApiInterface::class.java)
        }
        return apiInterface!!
    }

    private fun getClient(): Retrofit {
        if (retrofit == null) {
            val interceptorBody = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
            val interceptorHeader = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.HEADERS)
            val httpClient = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(interceptorBody)
                .addInterceptor(interceptorHeader)

            val okHttpClient = httpClient.build()
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()) //To get result as such in a model class (POJO)
                .client(okHttpClient)
                .build()
        }
        return retrofit!!
    }
}