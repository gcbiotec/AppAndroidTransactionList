package com.example.businesscontrollv3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.businesscontrollv3.model.type.ExpenseCategoryTypeEnum
import com.example.businesscontrollv3.model.type.IncomeType
import com.example.businesscontrollv3.model.type.TransactionTypeEnum

@Entity
data class Transaction(
    @ColumnInfo
    var value: String? = null,

    @ColumnInfo
    var description: String? = null,

    @ColumnInfo
    var transactionType: TransactionTypeEnum,

    @ColumnInfo
    var idResponsible: String? = null,

    @ColumnInfo
    var incomeType: IncomeType? = null,

    @ColumnInfo
    var expenseCategoryType: ExpenseCategoryTypeEnum,

    @ColumnInfo
    var destinationAccount: String? = null,

    @ColumnInfo
    var idAccount: String? = null,
)
{

    @PrimaryKey(
        autoGenerate = true)
    @ColumnInfo
    var idTransaction: Int? = null

}


//package com.example.businesscontrollv3.model
//
//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.PrimaryKey
//import com.example.businesscontrollv3.model.type.ExpenseCategoryTypeEnum
//import com.example.businesscontrollv3.model.type.IncomeType
//import com.example.businesscontrollv3.model.type.TransactionTypeEnum
//
//@Entity
//data class Transaction(
//    @ColumnInfo
//    var date: String? = "")
//@ColumnInfo
//var value: Double = 0.0
//@ColumnInfo
//var description: String? = null
//@ColumnInfo
//lateinit var transactionType: TransactionTypeEnum
//@ColumnInfo
//var idResponsible: Int = 0
//
//@PrimaryKey(autoGenerate = true)
//@ColumnInfo
//var idAccount: Int = 0
//
//@ColumnInfo
//var incomeType: IncomeType? = null
//@ColumnInfo
//var expenseCategoryType: ExpenseCategoryTypeEnum? = null
//@ColumnInfo
//var destinationAccount: Int? = null

