package com.example.businesscontrollv3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.businesscontrollv3.model.type.AccountTypeEnum

@Entity
data class Account(
        @ColumnInfo
        var name: String,
        @ColumnInfo
        var balance: Double,
        @ColumnInfo
        var responsibleId: Int,
        @ColumnInfo
        var accountTypeEnum: AccountTypeEnum){



        @PrimaryKey(autoGenerate = true)
        @ColumnInfo
        var idAccount: Int? = null


}