package com.kweboakye.spacextestapp.androidApp.model

import com.kweboakye.spacextestapp.shared.domain.model.RocketLaunch

sealed class LaunchesState

object LaunchesLoading : LaunchesState()

data class LaunchesSuccess(val rocketLaunches: List<RocketLaunch>) : LaunchesState()

data class LaunchesError(val error: String) : LaunchesState()
