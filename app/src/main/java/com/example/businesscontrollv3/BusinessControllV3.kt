package com.example.businesscontrollv3

import android.app.Application
import com.example.businesscontrollv3.infra.database.BCDatabase
import com.example.businesscontrollv3.repository.AccountRepository
import com.example.businesscontrollv3.repository.ResponsibleRepository
import com.example.businesscontrollv3.repository.TransactionRepository

class BusinessControllV3 : Application() {

    val database by lazy {BCDatabase.getDatabase(this)}

    val responsibleRepository by lazy{
        ResponsibleRepository(database.responsibleDAO())
        }

    val accountRepository by lazy{
        AccountRepository(database.accountDAO())
    }
    val transactionRepository by lazy{
        TransactionRepository(database.transactionDAO())
    }
}