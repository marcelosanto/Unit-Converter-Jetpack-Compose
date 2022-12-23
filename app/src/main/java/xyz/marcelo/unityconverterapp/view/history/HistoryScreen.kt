package xyz.marcelo.unityconverterapp.view.history

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import xyz.marcelo.unityconverterapp.data.ConversionResult

@Composable
fun HistoryScreen(
    historyList: State<List<ConversionResult>>,
    modifier: Modifier = Modifier,
    onCloseTask: (ConversionResult) -> Unit,
    onClearAllTask: () -> Unit
) {

    if (historyList.value.isNotEmpty()) {
        Column {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Histórico", color = Color.Gray)
                OutlinedButton(onClick = { onClearAllTask() }) {
                    Text(text = "Deletar todos", color = Color.Gray)
                }
            }
            HistoryList(list = historyList, onCloseTask = { item -> onCloseTask(item) })
        }
    }
}