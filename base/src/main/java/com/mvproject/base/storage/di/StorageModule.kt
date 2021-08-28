package com.mvproject.base.storage.di

import android.content.Context
import com.mvproject.base.storage.CurrentUserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {
    @Provides
    @Singleton
    fun providesCurrentUserRepository(
        @ApplicationContext context: Context
    ) = CurrentUserRepository(context)
}