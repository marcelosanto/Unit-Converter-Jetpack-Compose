package xyz.marcelo.androidapptemplate.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import xyz.marcelo.androidapptemplate.data.ConverterRepository

class ConverterViewModelFactory(private val repository: ConverterRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ConverterViewModel(repository) as T
}