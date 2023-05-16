package com.example.architectureexample.data.db

import androidx.room.*

@Dao
interface BaseDAO<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(t: T): Long

    @Update
    fun update(t: T)

    @Delete
    fun delete(t: T)
}