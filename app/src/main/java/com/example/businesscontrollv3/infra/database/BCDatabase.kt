package com.example.businesscontrollv3.infra.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.businesscontrollv3.model.Account
import com.example.businesscontrollv3.model.Responsible
import com.example.businesscontrollv3.model.Transaction
import com.example.businesscontrollv3.model.type.Converters

@Database(entities = [Responsible::class, Account::class, Transaction::class], version = 3, exportSchema = false)
@TypeConverters(value=[Converters::class])
abstract class BCDatabase : RoomDatabase() {

    abstract fun responsibleDAO(): ResponsibleDAO
    abstract fun accountDAO(): AccountDAO
    abstract fun transactionDAO(): TransactionDAO

    companion object {
        @Volatile
        private var INSTACE: BCDatabase? = null
        fun getDatabase(context: Context): BCDatabase {
            return INSTACE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BCDatabase::class.java,
                    "BCDatabase"
                )//.build()

                    .fallbackToDestructiveMigration()
                    .build()

                INSTACE = instance
                instance
            }
        }
    }
}