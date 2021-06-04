package com.example.businesscontrollv3.repository

import androidx.annotation.WorkerThread
import com.example.businesscontrollv3.infra.database.AccountDAO
import com.example.businesscontrollv3.model.Account

class AccountRepository(private val accountDAO: AccountDAO) {

    //fun getAccounts(): List<Account>{

    fun getAccounts() = accountDAO.getAllAccounts()

    @WorkerThread
    suspend fun save(account: Account) {
        accountDAO.save(account)
    }
    suspend fun deleteAccount(account: Account){
        this.accountDAO.delete(account)
    }
}

//        val account1 = Account("banco 1", 22.0 , 1, AccountTypeEnum.DEBITO)
//        val account2 = Account("banco 2", 289.0 , 1, AccountTypeEnum.DEBITO)
//
//        return listOf(account1, account2)
