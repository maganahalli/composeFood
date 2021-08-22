package com.mobile.venky.meal.model.network

import com.google.gson.GsonBuilder
import com.mobile.venky.meal.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import okio.IOException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitMealsCategoriesClient {

    private var retrofit: Retrofit? = null

    fun getRetrofitInstance(): Retrofit? {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient = OkHttpClient().newBuilder().addInterceptor(object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val originalRequest: Request = chain.request()
                val newRequest: Request =
                    originalRequest.newBuilder().header("Accept", "application/json")
                        .addHeader("Content-Type", "application/json")
                        .addHeader("X-ListenAPI-Key", WebServiceConfig.getApiKey()).build()
                return chain.proceed(newRequest)
            }
        }).addInterceptor(loggingInterceptor).build()
        val gson = GsonBuilder().serializeNulls()
            .setLenient()
            .create()
        if (retrofit == null) {
            retrofit = retrofit2.Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(WebServiceConfig.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return retrofit
    }
}