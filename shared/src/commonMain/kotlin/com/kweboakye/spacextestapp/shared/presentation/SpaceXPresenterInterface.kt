package com.kweboakye.spacextestapp.shared.presentation

import com.kweboakye.spacextestapp.shared.domain.model.RocketLaunch
import kotlin.Exception

interface SpaceXPresenterInterface {
    fun showLaunches(launches: List<RocketLaunch>)
    fun showLoading()
    fun showLaunchesError(errors: List<Exception>)
}
