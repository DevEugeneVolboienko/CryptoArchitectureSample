package com.example.architectureexample.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.architectureexample.data.entity.CryptoEntity
import io.reactivex.Single

@Dao
interface CryptoDAO : BaseDAO<CryptoEntity> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(cryptoEntities: List<CryptoEntity>)

    @Query("SELECT * FROM crypto WHERE symbol LIKE :symbol")
    fun selectCryptoBy(symbol: String): Single<List<CryptoEntity>>

    @Query("SELECT * FROM crypto")
    fun selectAll(): Single<List<CryptoEntity>>

    @Query("delete from crypto")
    fun deleteAll()
}