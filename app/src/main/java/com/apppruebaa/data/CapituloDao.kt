package com.apppruebaa.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.apppruebaa.model.Capitulo

@Dao
interface CapituloDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCapitulo(capitulo: Capitulo)
    @Query ("SELECT * FROM CAPITULO")
    fun getCapitulos() : LiveData<List<Capitulo>>
}