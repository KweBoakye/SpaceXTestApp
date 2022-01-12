package com.kweboakye.spacextestapp.androidApp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kweboakye.spacextestapp.androidApp.model.LaunchesError
import com.kweboakye.spacextestapp.androidApp.model.LaunchesLoading
import com.kweboakye.spacextestapp.androidApp.model.LaunchesState
import com.kweboakye.spacextestapp.androidApp.model.LaunchesSuccess
import com.kweboakye.spacextestapp.shared.domain.model.RocketLaunch
import com.kweboakye.spacextestapp.shared.presentation.SpaceXPresenterInterface
import kotlin.Exception

class SpaceXViewModel: ViewModel(), SpaceXPresenterInterface {

    private val launchesLiveData: MutableLiveData<LaunchesState> = MutableLiveData(LaunchesLoading)
    val launchesLiveDataPublic: LiveData<LaunchesState> = launchesLiveData

    override fun showLaunches(launches: List<RocketLaunch>) {
        launchesLiveData.value = LaunchesSuccess(launches)
    }

    override fun showLoading() {
        launchesLiveData.value = LaunchesLoading
    }

    override fun showLaunchesError(errors: List<Exception>) {
        launchesLiveData.value = LaunchesError( errors.first().toString())
    }


}