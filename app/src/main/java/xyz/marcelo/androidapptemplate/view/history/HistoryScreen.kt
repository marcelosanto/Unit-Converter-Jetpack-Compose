package xyz.marcelo.androidapptemplate.view.history

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import xyz.marcelo.androidapptemplate.data.ConversionResult

@Composable
fun HistoryScreen(
    historyList: State<List<ConversionResult>>,
    modifier: Modifier = Modifier
) {
    HistoryList(list = historyList, onCloseTask = {})
}