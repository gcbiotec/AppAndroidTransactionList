package com.example.businesscontrollv3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.businesscontrollv3.BusinessControllV3
import com.example.businesscontrollv3.repository.AccountRepository


class AccountViewModelFactory(val application: BusinessControllV3) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AccountViewModel::class.java)) {
            return AccountViewModel(application.accountRepository, application.responsibleRepository) as T
        }

        throw IllegalAccessException("Erro desconhecido")
    }
}