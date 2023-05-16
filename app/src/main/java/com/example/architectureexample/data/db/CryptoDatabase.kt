package com.example.architectureexample.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.architectureexample.data.entity.CryptoEntity

private const val DATABASE_VERSION = 1

@Database(entities = [CryptoEntity::class], version = DATABASE_VERSION, exportSchema = false)
abstract class CryptoDatabase : RoomDatabase() {
    abstract fun cryptoDAO(): CryptoDAO
}