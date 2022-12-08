package xyz.marcelo.androidapptemplate.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.marcelo.androidapptemplate.data.ConverterDatabase
import xyz.marcelo.androidapptemplate.data.ConverterRepository
import xyz.marcelo.androidapptemplate.data.ConverterRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideConverterDatabase(app: Application): ConverterDatabase {
        return Room.databaseBuilder(app, ConverterDatabase::class.java, "converter_data_database")
            .build()
    }

    @Provides
    @Singleton
    fun provideConverterRepository(db: ConverterDatabase): ConverterRepository {
        return ConverterRepositoryImpl(db.converterDAO)
    }
}