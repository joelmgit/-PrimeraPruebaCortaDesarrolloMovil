package com.apppruebaa.repository

import androidx.lifecycle.LiveData
import com.apppruebaa.data.CapituloDao
import com.apppruebaa.model.Capitulo

class CapituloRepository(private val capituloDao: CapituloDao) {
    suspend fun saveCapitulo(capitulo: Capitulo) {
        if (capitulo.idCapitulo==0) {
            capituloDao.addCapitulo(capitulo)
        }
    }
    val getCapitulos : LiveData<List<Capitulo>> = capituloDao.getCapitulos()
}