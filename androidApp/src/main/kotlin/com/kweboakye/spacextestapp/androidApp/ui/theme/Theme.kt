package com.kweboakye.spacextestapp.androidApp.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun SpaceXTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColours,
        typography = SpaceXTypography,
        content = content)
}

private val LightColours = lightColors(
    primary = Color.White,
    primaryVariant = Color.White,
    secondary = NasaBlue,
    secondaryVariant = NasaBlueLight,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    background = SpaceGrey

)
