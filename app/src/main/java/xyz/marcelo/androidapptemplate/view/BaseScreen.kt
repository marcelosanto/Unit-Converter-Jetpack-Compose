package xyz.marcelo.androidapptemplate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import xyz.marcelo.androidapptemplate.view.HistoryScreen
import xyz.marcelo.androidapptemplate.view.TopScreen

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel()
) {
    val list = converterViewModel.getConversions()

    Column(modifier = modifier.padding(30.dp)) {
        TopScreen(list)
        Spacer(modifier = modifier.height(20.dp))
        HistoryScreen()
    }
}