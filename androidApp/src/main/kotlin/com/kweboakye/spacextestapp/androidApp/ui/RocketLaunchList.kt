package com.kweboakye.spacextestapp.androidApp.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kweboakye.spacextestapp.shared.domain.model.Links
import com.kweboakye.spacextestapp.shared.domain.model.Rocket
import com.kweboakye.spacextestapp.shared.domain.model.RocketLaunch

@Composable
fun RocketLaunchList(rocketLaunchesList: List<RocketLaunch>) {
    Surface(Modifier.fillMaxSize(), color = Color.Gray) {
        LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
        ) {itemsIndexed(rocketLaunchesList)
            { index: Int,
              rocketLaunch: RocketLaunch ->
                RocketLaunchRow(rocketLaunch = rocketLaunch)
                if (index > rocketLaunchesList.size) Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun RocketLaunchError(error: String) {
    Text(error)
}



@Preview
@Composable
fun RocketLaunchListPreview() {

    val rocketLaunch = RocketLaunch(
        1,
        "missionName",
        2020,
        "launchDate",
        Rocket(
            "id",
            "name",
            "type"),
        "details",
        true,
        Links(
            "missionPatchUrl",
            "articleUrl"
        )
    )
    RocketLaunchList(rocketLaunchesList = List(10){
        rocketLaunch
    })
}
