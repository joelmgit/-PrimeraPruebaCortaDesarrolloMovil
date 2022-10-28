package com.apppruebaa.viewmodel

import com.apppruebaa.data.CapituloDatabase
import android.app.Application
import androidx.lifecycle.*
import com.apppruebaa.model.Capitulo
import com.apppruebaa.repository.CapituloRepository
import kotlinx.coroutines.launch

class CapituloViewModel(application: Application) : AndroidViewModel(application) {
    val getCapitulos : LiveData<List<Capitulo>>
    private val repository: CapituloRepository
    init {
        val capituloDao = CapituloDatabase.getDatabase(application).capituloDao()
        repository = CapituloRepository(capituloDao)
        getCapitulos = repository.getCapitulos
    }
    fun saveCapitulo(capitulo: Capitulo) {
        viewModelScope.launch { repository.saveCapitulo(capitulo) }
    }
}