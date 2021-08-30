package com.mvproject.firstappmodule.spanish

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvproject.base.model.ItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class SpanishViewModel @Inject constructor(
    private val spanishClubsRepository: SpanishClubsRepository
) : ViewModel() {

    private val _dataState = MutableLiveData<List<ItemModel>>(emptyList())
    val dataState = _dataState

    fun obtainClubs() = viewModelScope.launch {
        runCatching {
            spanishClubsRepository.obtainSpanishClubs()
        }.onSuccess {
            _dataState.postValue(it)
        }.onFailure {
            _dataState.postValue(emptyList())
        }
    }
}
