package com.mvproject.base.login

import androidx.lifecycle.ViewModel
import com.mvproject.base.storage.CurrentUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val currentUserRepository: CurrentUserRepository
) : ViewModel() {

    fun checkUserLogged() = currentUserRepository.isUserLogged()

    fun logUser(user: String) = currentUserRepository.setUserLogged(user)
}
