package com.kweboakye.spacextestapp.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.activity.ComponentActivity
import com.kweboakye.spacextestapp.androidApp.di.SpaceXControllerFactory
import com.kweboakye.spacextestapp.androidApp.ui.MainPage
import com.kweboakye.spacextestapp.shared.presentation.SpaceXController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val spaceXViewModel: SpaceXViewModel by viewModels()

    @Inject
    lateinit var spaceXControllerFactory: SpaceXControllerFactory
    lateinit var spaceXController: SpaceXController

    @Inject
    lateinit var check: Check

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        spaceXController = spaceXControllerFactory.create(spaceXViewModel)

        setContent {
            MainPage(spaceXController, spaceXViewModel.launchesLiveDataPublic)
        }
    }
}
