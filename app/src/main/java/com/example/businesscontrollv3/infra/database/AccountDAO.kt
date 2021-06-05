package com.example.businesscontrollv3.infra.database

import androidx.room.*
import com.example.businesscontrollv3.model.Account
import com.example.businesscontrollv3.model.projection.AccountProjection
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDAO {

        @Transaction
        @Query("SELECT * FROM Account ORDER BY name ASC")

        fun getAllAccount(): Flow<List<AccountProjection>>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun save(account: Account)

        @Delete
        suspend fun delete(account: Account)
    }
