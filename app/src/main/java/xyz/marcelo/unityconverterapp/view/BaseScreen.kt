package xyz.marcelo.unityconverterapp.view

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import xyz.marcelo.unityconverterapp.view.components.TopScreen
import xyz.marcelo.unityconverterapp.view.history.HistoryScreen
import xyz.marcelo.unityconverterapp.view.viewmodel.ConverterViewModel
import xyz.marcelo.unityconverterapp.view.viewmodel.ConverterViewModelFactory

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel(factory = factory)
) {
    val list = converterViewModel.getConversions()
    val historyList = converterViewModel.resultList.collectAsState(initial = emptyList())

    val configuration = LocalConfiguration.current
    var isLandscape by remember { mutableStateOf(false) }

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            isLandscape = true
            Row(
                modifier = modifier
                    .padding(30.dp)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                TopScreen(
                    list,
                    converterViewModel.selectedConversion,
                    converterViewModel.inputText,
                    converterViewModel.typedValue,
                    isLandscape
                ) { msg1, msg2 ->
                    converterViewModel.addResult(msg1, msg2)
                }

                Spacer(modifier = modifier.width(10.dp))

                HistoryScreen(historyList, onCloseTask = { item ->
                    converterViewModel.removeResult(item)
                }) {
                    converterViewModel.removeAllResult()
                }
            }
        }
        else -> {
            isLandscape = false
            Column(modifier = modifier.padding(30.dp)) {
                TopScreen(
                    list,
                    converterViewModel.selectedConversion,
                    converterViewModel.inputText,
                    converterViewModel.typedValue,
                    isLandscape
                ) { msg1, msg2 ->
                    converterViewModel.addResult(msg1, msg2)
                }

                Spacer(modifier = modifier.height(20.dp))

                HistoryScreen(historyList, onCloseTask = { item ->
                    converterViewModel.removeResult(item)
                }) {
                    converterViewModel.removeAllResult()
                }
            }
        }
    }


}