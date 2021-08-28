package com.mvproject.moduleskeleton.firstmodule.english

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvproject.base.model.ItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EnglishViewModel @Inject constructor(
    private val englishClubsRepository: EnglishClubsRepository
) : ViewModel() {

    private val _dataState = MutableLiveData<List<ItemModel>>(emptyList())
    val dataState = _dataState

    fun obtainClubs() = viewModelScope.launch {
        runCatching {
            englishClubsRepository.obtainEnglishClubs()
        }.onSuccess {
            _dataState.postValue(it)
        }.onFailure {
            _dataState.postValue(emptyList())
        }
    }
}