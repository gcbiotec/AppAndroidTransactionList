package com.example.businesscontrollv3.infra.database


import androidx.room.*
import com.example.businesscontrollv3.model.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDAO {

    @Query("SELECT * FROM 'Transaction' ORDER BY value ASC")

    fun getAllTransactions(): Flow<List<Transaction>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(transaction: com.example.businesscontrollv3.model.Transaction)

    @Delete
    suspend fun delete(transaction: Transaction)

}