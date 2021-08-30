package com.mvproject.firstappmodule.spanish

import com.mvproject.base.model.ItemModel
import com.mvproject.base.network.Endpoints
import javax.inject.Inject

class SpanishClubsRepository @Inject constructor(
    private val api: Endpoints
) {
    suspend fun obtainSpanishClubs(): List<ItemModel> = api.getSpanishClubs()
}
