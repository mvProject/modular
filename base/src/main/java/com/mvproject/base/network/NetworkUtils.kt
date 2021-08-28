package com.mvproject.moduleskeleton.network

sealed class UiState{
    object Idle: UiState()
    object Loading: UiState()
    object Error: UiState()
    object Success: UiState()
}

