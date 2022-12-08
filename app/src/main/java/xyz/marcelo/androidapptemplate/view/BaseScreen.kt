package xyz.marcelo.androidapptemplate.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import xyz.marcelo.androidapptemplate.view.history.HistoryScreen
import xyz.marcelo.androidapptemplate.view.viewmodel.ConverterViewModel
import xyz.marcelo.androidapptemplate.view.viewmodel.ConverterViewModelFactory

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel(factory = factory)
) {
    val list = converterViewModel.getConversions()
    val historyList = converterViewModel.resultList.collectAsState(initial = emptyList())

    Column(modifier = modifier.padding(30.dp)) {
        TopScreen(list) { msg1, msg2 ->
            converterViewModel.addResult(msg1, msg2)
        }

        Spacer(modifier = modifier.height(20.dp))

        HistoryScreen(historyList)
    }
}