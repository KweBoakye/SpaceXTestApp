package com.kweboakye.spacextestapp.androidApp.di

import com.kweboakye.spacextestapp.shared.data.database.SpaceXRepository
import com.kweboakye.spacextestapp.shared.data.network.SpaceXApi
import com.kweboakye.spacextestapp.shared.domain.interactors.SpaceXInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent


@InstallIn(ActivityComponent::class)
@Module
object DomainModule {

    @Provides
    fun providesSpaceXInteractor(
        spaceXRepository: SpaceXRepository,
        spaceXApi: SpaceXApi) : SpaceXInteractor{
        return SpaceXInteractor(spaceXRepository, spaceXApi)
    }

}
