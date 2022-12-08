package xyz.marcelo.androidapptemplate.view.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import xyz.marcelo.androidapptemplate.data.Conversion

@Composable
fun ConversionMenu(
    list: List<Conversion>,
    modifier: Modifier = Modifier,
    convert: (Conversion) -> Unit
) {
    val displayingText = rememberSaveable { mutableStateOf("Selecione o tipo de conversão") }
    val textFieldSize = remember { mutableStateOf(Size.Zero) }
    val expanded = remember { mutableStateOf(false) }
    val icon = if (expanded.value) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown

    Column {
        OutlinedTextField(
            value = displayingText.value,
            onValueChange = { displayingText.value = it },
            textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = modifier
                .fillMaxWidth()
                .onGloballyPositioned { coord ->
                    textFieldSize.value = coord.size.toSize()
                },
            label = { Text(text = "Tipos de Conversões") },
            trailingIcon = {
                Icon(imageVector = icon, contentDescription = "icon",
                    modifier.clickable { expanded.value = !expanded.value })
            },
            readOnly = true
        )

        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false },
            modifier = modifier.width(with(LocalDensity.current) { textFieldSize.value.width.toDp() })
        ) {
            list.forEach { conversion ->
                DropdownMenuItem(onClick = {
                    displayingText.value = conversion.description
                    expanded.value = false
                    convert(conversion)
                }) {
                    Text(
                        text = conversion.description,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }

}