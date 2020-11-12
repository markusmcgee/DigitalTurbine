package com.pnpc.dt.app.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit

object DTServiceGenerator {
    private const val API_BASE_URL = "http://ads.appia.com"
    private fun retrofitService(): Retrofit {
        return Retrofit.Builder()
            .client(OkHttpClient().newBuilder().build())
            .baseUrl(API_BASE_URL)
            .build()
    }

    val APIService: DTAPIService by lazy {
        retrofitService().create(DTAPIService::class.java)
    }
}
