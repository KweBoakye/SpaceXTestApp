package com.kweboakye.spacextestapp.shared.presentation

import com.kweboakye.spacextestapp.shared.domain.interactors.SpaceXInteractor
import com.kweboakye.spacextestapp.shared.domain.model.ResultOrError
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class SpaceXController(
    private val spaceXInteractor: SpaceXInteractor,
    private val spaceXPresenterInterface: SpaceXPresenterInterface
) {
    private val job: Job = SupervisorJob()
    private val context: CoroutineContext = Dispatchers.Main + job
    private val spaceXControllerCoroutineScope: CoroutineScope = CoroutineScope(context)

    fun loadAndDisplayLaunches(forceReload: Boolean) = spaceXControllerCoroutineScope.launch {
        spaceXPresenterInterface.showLoading()
        when (val launches = spaceXInteractor.getLaunches(forceReload)) {
            is ResultOrError.Success -> launches
                .value
                .run(spaceXPresenterInterface::showLaunches)
            is ResultOrError.Failure -> launches
                .errors
                .run(spaceXPresenterInterface::showLaunchesError)
        }
    }
}
