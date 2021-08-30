package com.mvproject.firstappmodule.english

import com.mvproject.base.model.ItemModel
import com.mvproject.base.network.Endpoints
import javax.inject.Inject

class EnglishClubsRepository @Inject constructor(
    private val api: Endpoints
) {
    suspend fun obtainEnglishClubs(): List<ItemModel> = api.getEnglishClubs()
}
