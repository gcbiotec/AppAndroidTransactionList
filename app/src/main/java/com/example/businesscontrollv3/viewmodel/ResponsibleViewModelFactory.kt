package com.example.businesscontrollv3.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.businesscontrollv3.BusinessControllV3

class ResponsibleViewModelFactory(val application: BusinessControllV3) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResponsibleViewModel::class.java)) {
            //val repository = LoginRepository()
            return ResponsibleViewModel(application.responsibleRepository) as T
        }

        throw IllegalAccessException("Erro desconhecido")
    }
}
