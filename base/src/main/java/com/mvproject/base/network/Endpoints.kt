package com.mvproject.base.network

import com.mvproject.base.model.ItemModel
import retrofit2.http.GET

// https://mocki.io/v1/19ba3185-17b0-4218-b2a4-98bddd6c9e6d - english
// https://mocki.io/v1/7b53f8f6-91ac-4d94-8f40-c02dcc2370e4 - spanish
const val BASE_URL = "https://mocki.io/v1/"
interface Endpoints {
    @GET("7b53f8f6-91ac-4d94-8f40-c02dcc2370e4")
    suspend fun getSpanishClubs(): List<ItemModel>

    @GET("19ba3185-17b0-4218-b2a4-98bddd6c9e6d")
    suspend fun getEnglishClubs(): List<ItemModel>
}
