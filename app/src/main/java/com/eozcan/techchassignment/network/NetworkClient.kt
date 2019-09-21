package com.eozcan.techchassignment.network

import com.eozcan.techchassignment.constants.Settings
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient {
    companion object {
        fun getService(): AssignmentNetworkService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create()
                )
                .addConverterFactory(
                    GsonConverterFactory.create()
                )
                .baseUrl(Settings.BASE_URL)
                .build()
            return retrofit.create(AssignmentNetworkService::class.java)
        }
    }
}