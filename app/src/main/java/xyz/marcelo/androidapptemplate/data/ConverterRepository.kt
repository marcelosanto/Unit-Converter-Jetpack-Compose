package xyz.marcelo.androidapptemplate.data

import kotlinx.coroutines.flow.Flow


interface ConverterRepository {

    suspend fun insertResult(result: ConversionResult)
    suspend fun deleteResult(result: ConversionResult)
    suspend fun deleteAllResults()
    suspend fun getSavedResults(): Flow<List<ConversionResult>>
}