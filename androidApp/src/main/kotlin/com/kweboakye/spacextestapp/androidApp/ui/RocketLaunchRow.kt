package com.kweboakye.spacextestapp.androidApp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.kweboakye.spacextestapp.shared.domain.model.Links
import com.kweboakye.spacextestapp.shared.domain.model.Rocket
import com.kweboakye.spacextestapp.shared.domain.model.RocketLaunch
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RocketLaunchRow(rocketLaunch: RocketLaunch){
    Card(elevation = 4.dp) {
    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        Column() {
            Text("LaunchName: ${rocketLaunch.missionName}")
            RocketLaunchRowLaunchTextSetter(rocketLaunch.launchSuccess)
            Text("Launch Year: ${rocketLaunch.launchYear}")
            Text("Launch Details: ${rocketLaunch.details ?: ""}")
        }
    }

    }
}

@Composable
fun RocketLaunchRowLaunchTextSetter(rocketLaunchSuccess: Boolean?){
    when (rocketLaunchSuccess) {
        true -> RocketLaunchRowLaunchText("Successful", Color.Green)
        false -> RocketLaunchRowLaunchText("Unsuccessful", Color.Red)
        null -> RocketLaunchRowLaunchText("No Data", Color.Gray)
    }
}

@Composable
fun RocketLaunchRowLaunchText(launchText: String, textColour: Color){
    Text(launchText, color = textColour)
}


@Preview
@Composable
fun RocketLaunchRowPreview(){
    RocketLaunchRow(
        RocketLaunch(
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
    )
}
