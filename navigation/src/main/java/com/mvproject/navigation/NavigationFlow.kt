package com.mvproject.navigation

sealed class NavigationFlow {
    object LoginFlow : NavigationFlow()
    object FirstAppFlow : NavigationFlow()
    object SecondAppFlow : NavigationFlow()
}
