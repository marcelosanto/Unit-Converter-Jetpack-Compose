package xyz.marcelo.androidapptemplate.view

import androidx.compose.runtime.*
import xyz.marcelo.androidapptemplate.data.Conversion
import xyz.marcelo.androidapptemplate.view.components.ConversionMenu
import xyz.marcelo.androidapptemplate.view.components.InputBlock
import xyz.marcelo.androidapptemplate.view.components.ResultBlock
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TopScreen(
    list: List<Conversion>,
    selectedConversion: MutableState<Conversion?>,
    inputText: MutableState<String>,
    typedValue: MutableState<String>,
    save: (String, String) -> Unit
) {
    var toSave by remember {
        mutableStateOf(false)
    }

    ConversionMenu(list = list) {
        selectedConversion.value = it
        typedValue.value = "0.0"
    }

    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText = inputText) { input ->
            typedValue.value = input
            toSave = true
        }
    }

    if (typedValue.value != "0.0") {
        val input = typedValue.value.toDouble()
        val multiply = selectedConversion.value!!.multiplyBy
        val result = input * multiply

        //arrendondar resultado
        val df = DecimalFormat("#.####")
        df.roundingMode = RoundingMode.DOWN
        val roundedResult = df.format(result)

        val message1 = "${typedValue.value} ${selectedConversion.value!!.convertFrom} é igual a"
        val message2 = "$roundedResult ${selectedConversion.value!!.convertTo}"

        if (toSave) {
            save(message1, message2)
            toSave = false
        }
        ResultBlock(message1 = message1, message2 = message2)
    }
}