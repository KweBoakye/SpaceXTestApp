package com.kweboakye.spacextestapp.androidApp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.kweboakye.spacextestapp.androidApp.ui.theme.SpaceXTheme

@Composable
fun AppBar(reloadFunction: () -> Unit) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.secondary
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
        TopAppBarText()
        ReloadButton(reloadFunction = reloadFunction)
        }
    }
}

@Composable
fun TopAppBarText() {
    Text(
        text = "SpaceX Launches",
        style = MaterialTheme.typography.h4,
        color = MaterialTheme.colors.onSecondary
    )
}

@Composable
fun ReloadButton(reloadFunction: () -> Unit){
    Button(onClick = reloadFunction) {
        Text(text = "Reload")
    }
}

@Preview
@Composable
fun AppBarPreview(){
    AppBar(reloadFunction = {})
}
