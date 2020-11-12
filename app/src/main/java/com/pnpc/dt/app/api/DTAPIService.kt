package com.pnpc.dt.app.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DTAPIService {
    @GET("/getAds?id=236&password=OVUJ1DJN&siteId=10777&deviceId=4230&sessionId=techtestsession&totalCampaignsRequested=10")
    fun getAds(@Query("lname") format: String?): Call<ResponseBody>?
}