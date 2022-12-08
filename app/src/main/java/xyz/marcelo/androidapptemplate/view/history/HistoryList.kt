package xyz.marcelo.androidapptemplate.view.history

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import xyz.marcelo.androidapptemplate.data.ConversionResult

@Composable
fun HistoryList(
    list: State<List<ConversionResult>>,
    modifier: Modifier = Modifier,
    onCloseTask: (ConversionResult) -> Unit
) {
    LazyColumn {
        items(items = list.value, key = { item -> item.id }) { item ->
            HistoryItem(
                messagePart1 = item.messagePart1,
                messagePart2 = item.messagePart2,
                onClose = { onCloseTask(item) })
        }
    }
}