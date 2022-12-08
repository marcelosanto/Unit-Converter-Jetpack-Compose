package xyz.marcelo.androidapptemplate.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import xyz.marcelo.androidapptemplate.data.Conversion
import xyz.marcelo.androidapptemplate.data.ConversionResult
import xyz.marcelo.androidapptemplate.data.ConverterRepository

class ConverterViewModel(private val repository: ConverterRepository) : ViewModel() {
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