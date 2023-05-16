package com.example.architectureexample.presentation.di.module

import androidx.room.Room
import com.example.architectureexample.core.App
import com.example.architectureexample.data.db.CryptoDAO
import com.example.architectureexample.data.db.CryptoDatabase
import com.example.architectureexample.data.interactor.GetCryptoInteractor
import com.example.architectureexample.data.network.CryptoApi
import com.example.architectureexample.data.repository.CryptoRepositoryImpl
import com.example.architectureexample.domain.repository.CryptoRepository
import com.example.architectureexample.domain.usecase.GetCryptoUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

private const val DATABASE_NAME = "crypto.db"

@Module
class RoomModule {
    @Singleton
    @Provides
    fun provideCryptoDatabase(app: App): CryptoDatabase =
        Room.databaseBuilder(app, CryptoDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideCryptoDao(cryptoDatabase: CryptoDatabase): CryptoDAO = cryptoDatabase.cryptoDAO()

    @Singleton
    @Provides
    fun provideCryptoRepository(cryptoDAO: CryptoDAO, cryptoApi: CryptoApi): CryptoRepository =
        CryptoRepositoryImpl(cryptoDAO, cryptoApi)

    @Singleton
    @Provides
    fun provideGetCryptoUseCase(cryptoRepository: CryptoRepository): GetCryptoUseCase =
        GetCryptoInteractor(cryptoRepository)
}