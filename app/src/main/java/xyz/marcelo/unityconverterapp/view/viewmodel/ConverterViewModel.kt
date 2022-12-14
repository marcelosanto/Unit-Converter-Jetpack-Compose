package xyz.marcelo.unityconverterapp.view.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import xyz.marcelo.unityconverterapp.data.Conversion
import xyz.marcelo.unityconverterapp.data.ConversionResult
import xyz.marcelo.unityconverterapp.data.ConverterRepository

class ConverterViewModel(private val repository: ConverterRepository) : ViewModel() {
    val selectedConversion: MutableState<Conversion?> = mutableStateOf(null)
    val inputText: MutableState<String> = mutableStateOf("")
    val typedValue = mutableStateOf("0.0")

    fun getConversions() = listOf(
        Conversion(1, "KG para Gramas", "KG", "GR", 1000.0),
        Conversion(2, "Gramas para KG", "GR", "KG", 0.001),
        Conversion(3, "Metro para Centímetro", "M", "CM", 100.0),
        Conversion(4, "Centímetro para Metro", "CM", "M", 0.01),
        Conversion(5, "Litro para Mililitro", "LT", "ML", 1000.0),
        Conversion(6, "Mililitro para Litro", "ML", "LT", 0.001),
    )

    val resultList = repository.getSavedResults()

    fun addResult(message1: String, message2: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertResult(ConversionResult(0, message1, message2))
        }
    }

    fun removeResult(item: ConversionResult) =
        viewModelScope.launch(Dispatchers.IO) { repository.deleteResult(item) }

    fun removeAllResult() =
        viewModelScope.launch(Dispatchers.IO) { repository.deleteAllResults() }

}