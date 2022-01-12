package com.kweboakye.spacextestapp.androidApp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kweboakye.spacextestapp.androidApp.R

private val BankGothic = FontFamily(
    Font(R.font.bank_gothic_regular)
)

val SpaceXTypography = Typography(
    h4 = TextStyle(
        fontFamily = BankGothic,
        fontSize = 30.sp
    ),
    h5 = TextStyle(
        fontFamily = BankGothic,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = BankGothic,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = BankGothic,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = BankGothic,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = BankGothic,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = BankGothic,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = BankGothic,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = BankGothic,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = BankGothic,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    )

)
