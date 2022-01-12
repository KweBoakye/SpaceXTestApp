package com.kweboakye.spacextestapp.androidApp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.lifecycle.LiveData
import com.kweboakye.spacextestapp.androidApp.model.LaunchesState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kweboakye.spacextestapp.androidApp.model.LaunchesError
import com.kweboakye.spacextestapp.androidApp.model.LaunchesLoading
import com.kweboakye.spacextestapp.androidApp.model.LaunchesSuccess
import com.kweboakye.spacextestapp.androidApp.ui.theme.SpaceXTheme
import com.kweboakye.spacextestapp.shared.presentation.SpaceXController

@Composable
fun MainPage(spaceXController: SpaceXController, launchesLiveData: LiveData<LaunchesState>) {
    val launchesState: LaunchesState? by launchesLiveData.observeAsState()

    SideEffect  { spaceXController.loadAndDisplayLaunches(false) }
    SpaceXTheme {
        Scaffold(
            topBar = {
                AppBar(reloadFunction = {
                    spaceXController.loadAndDisplayLaunches(true) }) }) {

            Column() {
                launchesState?.let { MainContent(launchesState = it) } ?: MainContent(LaunchesLoading)
            }
        }
    }
}

@Composable
fun MainContent(launchesState: LaunchesState) {
    when (launchesState) {
        is LaunchesLoading -> RocketLaunchLoading()
        is LaunchesSuccess -> RocketLaunchList(launchesState.rocketLaunches)
        is LaunchesError -> RocketLaunchError(error = launchesState.error)
    }
}

@Composable
fun RocketLaunchLoading() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(Modifier.size(30.dp))
    }
}

@Preview
@Composable
fun RocketLaunchLoadingPreview() {
    RocketLaunchLoading()
}
