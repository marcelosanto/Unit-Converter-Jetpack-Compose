package xyz.marcelo.androidapptemplate.view

import androidx.compose.runtime.Composable
import xyz.marcelo.androidapptemplate.ConversionMenu
import xyz.marcelo.androidapptemplate.model.Conversion

@Composable
fun TopScreen(list: List<Conversion>) {
    ConversionMenu(list = list)
}