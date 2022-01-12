package com.kweboakye.spacextestapp.androidApp.di

import com.kweboakye.spacextestapp.androidApp.Check
import com.kweboakye.spacextestapp.shared.domain.interactors.SpaceXInteractor
import com.kweboakye.spacextestapp.shared.presentation.SpaceXController
import com.kweboakye.spacextestapp.shared.presentation.SpaceXPresenterInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

//typealias SpaceXControllerFactory = (SpaceXPresenterInterface) -> SpaceXController

@InstallIn(ActivityComponent::class)
@Module
object PresentationComponent {

    @Provides
    fun providesCheck(): Check {
        return Check()
    }

   /* @Provides
    fun providesSpaceXController(
        spaceXInteractor: SpaceXInteractor,
        spaceXPresenterInterface: SpaceXPresenterInterface
    ): SpaceXController {
        return SpaceXController(spaceXInteractor, spaceXPresenterInterface)
    }*/

    @Provides
    fun providesSpaceXControllerFactory(
        spaceXInteractor: SpaceXInteractor
    ): SpaceXControllerFactory {
        return SpaceXControllerFactory(spaceXInteractor)
    }
}

class SpaceXControllerFactory(private val spaceXInteractor: SpaceXInteractor){

    fun create(spaceXPresenterInterface: SpaceXPresenterInterface): SpaceXController{
        return SpaceXController(spaceXInteractor,spaceXPresenterInterface)
    }
}
