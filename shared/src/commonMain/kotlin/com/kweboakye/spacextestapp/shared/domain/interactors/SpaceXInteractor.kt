package com.kweboakye.spacextestapp.shared.domain.interactors

import com.kweboakye.spacextestapp.shared.data.database.SpaceXRepository
import com.kweboakye.spacextestapp.shared.data.network.SpaceXApi
import com.kweboakye.spacextestapp.shared.domain.model.ResultOrError
import com.kweboakye.spacextestapp.shared.domain.model.RocketLaunch
import com.kweboakye.spacextestapp.shared.domain.model.toResultOrErrorFailure
import com.kweboakye.spacextestapp.shared.domain.model.toResultOrErrorSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SpaceXInteractor(
    private val spaceXRepository: SpaceXRepository,
    private val spaceXApi: SpaceXApi
) {

    suspend fun getLaunchesAsStateFlow(forceReload: Boolean): StateFlow<ResultOrError<List<RocketLaunch>>>{
        return MutableStateFlow(getLaunches(forceReload))
    }

    suspend fun getLaunches(forceReload: Boolean):
            ResultOrError<List<RocketLaunch>> {
        val cachedLaunches: List<RocketLaunch> = spaceXRepository.getAllLaunches()
        return runCatching {
            when {
                (cachedLaunches.isNotEmpty()) && !(forceReload) -> cachedLaunches
                    .toResultOrErrorSuccess()
                else -> {
                    spaceXRepository.clearDatabase()
                    getAllLaunchesFromApi()
                }
            }
        }.getOrElse { throwable: Throwable ->
            (throwable as Exception).toResultOrErrorFailure()
        }
    }

    private suspend fun getAllLaunchesFromApi(): ResultOrError<List<RocketLaunch>> {
        return when (val launches = spaceXApi.getAllLaunches()) {
            is ResultOrError.Success -> launches
                .value
                .also(spaceXRepository::createLaunches)
                .toResultOrErrorSuccess()
            is ResultOrError.Failure -> launches
        }
    }
}
