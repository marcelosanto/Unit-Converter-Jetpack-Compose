package xyz.marcelo.androidapptemplate

import androidx.lifecycle.ViewModel
import xyz.marcelo.androidapptemplate.data.Conversion

class ConverterViewModel : ViewModel() {
    fun getConversions() = listOf(
        Conversion(1, "KG para Gramas", "KG", "GR", 1000.0),
        Conversion(2, "Gramas para KG", "GR", "KG", 0.001),
        Conversion(3, "Metro para Centímetro", "M", "CM", 100.0),
        Conversion(4, "Centímetro para Metro", "CM", "M", 0.01),
        Conversion(5, "Litro para Mililitro", "LT", "ML", 1000.0),
        Conversion(6, "Mililitro para Litro", "ML", "LT", 0.001),
    )
}