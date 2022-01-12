package com.kweboakye.spacextestapp.shared.di

import com.kweboakye.spacextestapp.shared.data.database.DatabaseDriverFactory
import com.kweboakye.spacextestapp.shared.data.database.SpaceXRepository
import com.kweboakye.spacextestapp.shared.data.network.SpaceXApi
import com.kweboakye.spacextestapp.shared.domain.interactors.SpaceXInteractor
import com.kweboakye.spacextestapp.shared.presentation.SpaceXController
import com.kweboakye.spacextestapp.shared.presentation.SpaceXPresenterInterface

object Dependencies {

    private fun getSpaceXRepository(): SpaceXRepository = SpaceXRepository(DatabaseDriverFactory())

    private fun getSpaceXInteractor(): SpaceXInteractor{
        return SpaceXInteractor(getSpaceXRepository(), SpaceXApi())
    }

    fun getSpaceXController(spaceXPresenterInterface: SpaceXPresenterInterface): SpaceXController{
        return SpaceXController(getSpaceXInteractor(), spaceXPresenterInterface)
    }
}
