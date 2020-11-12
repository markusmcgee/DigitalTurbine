package com.pnpc.dt.app.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.pnpc.dt.app.api.DTServiceGenerator
import com.pnpc.dt.app.model.AdXmlData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdsViewModel : ViewModel() {

    private var data: MutableLiveData<ArrayList<Any>>? = null
    private var call: Call<ResponseBody>? = null

    val selectedAd = MutableLiveData<Any>()

    fun getAds(): LiveData<ArrayList<Any>>? {
        if (data == null) {
            data = MutableLiveData()
            loadAds()
        }
        return data
    }

    private fun loadAds() {
        var convertedArrayList = mutableListOf<Any>()
        call = DTServiceGenerator.APIService.getAds("mcgee")
        call?.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val xmlString = response.body()?.bytes()?.let { String(it) }
                val xmlMapper = XmlMapper()
                val xmlObjects = xmlMapper.readValue(
                        xmlString,
                        ArrayList<AdXmlData>()::class.java
                )

                try {

                    for (i in 0..xmlObjects.size) {
                        val keys = (xmlObjects[i] as LinkedHashMap<*, *>).keys
                        if (keys.contains("appId")) {
                            val mapOfValues = mutableMapOf<String, Any>()
                            for (key in keys) {
                                val tempVal = (xmlObjects[i] as LinkedHashMap<*, *>)[key] ?: ""
                                mapOfValues[key as String] = tempVal
                            }
                            convertedArrayList.add(mapOfValues)
                        }
                    }
                } catch (e: Exception) {
                    // Lot's of dirty data in this call :-/....
                }

                data?.value = ArrayList(convertedArrayList)
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                //empty results
                data = MutableLiveData<ArrayList<Any>>()
            }

        })
    }
}


