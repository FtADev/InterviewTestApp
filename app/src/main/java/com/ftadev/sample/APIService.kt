package com.ftadev.sample

import Model
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIService {
    @GET("Category")
    fun getCategory(): Single<Model>

    companion object {
        val instance: APIService by lazy {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://208.109.13.111:6677/api/")
                .build()

            retrofit.create(APIService::class.java)
        }
    }
}

