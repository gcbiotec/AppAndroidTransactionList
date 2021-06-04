package com.example.businesscontrollv3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.businesscontrollv3.BusinessControllV3

class TransactionViewModelFactory(val application: BusinessControllV3) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransactionViewModel::class.java)) {
            //val repository = LoginRepository()
            return TransactionViewModel(application.transactionRepository) as T
        }

        throw IllegalAccessException("Erro desconhecido")
    }
}