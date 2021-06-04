package com.example.businesscontrollv3.repository

import androidx.annotation.WorkerThread
import com.example.businesscontrollv3.infra.database.ResponsibleDAO
import com.example.businesscontrollv3.infra.database.TransactionDAO
import com.example.businesscontrollv3.model.Responsible
import com.example.businesscontrollv3.model.Transaction

class TransactionRepository(private val transactionDAO: TransactionDAO) {

    fun getTransactions() = transactionDAO.getAllTransactions()
    @WorkerThread
    suspend fun save(transaction: Transaction){
        transactionDAO.save(transaction)
    }

}
//            val transaction1 = Transaction()
//            val transaction2 = Transaction()
//
//            return listOf(transaction1, transaction2)