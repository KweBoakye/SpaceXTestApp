package com.kweboakye.spacextestapp.androidApp.di

import android.content.Context
import com.kweboakye.spacextestapp.shared.data.database.DatabaseDriverFactory
import com.kweboakye.spacextestapp.shared.data.database.SpaceXRepository
import com.kweboakye.spacextestapp.shared.data.network.SpaceXApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    @Singleton
    fun providesDatabaseDriverFactory(@ApplicationContext context: Context): DatabaseDriverFactory {
        return DatabaseDriverFactory(context)
    }

    @Provides
    @Singleton
    fun providesSpaceXRepository(databaseDriverFactory: DatabaseDriverFactory): SpaceXRepository {
        return SpaceXRepository(databaseDriverFactory)
    }

    @Provides
    @Singleton
    fun providesSpaceXApi(): SpaceXApi{
        return SpaceXApi()
    }

}
