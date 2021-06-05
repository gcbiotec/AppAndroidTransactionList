package com.example.businesscontrollv3.model.projection

import androidx.room.Embedded
import androidx.room.Relation
import com.example.businesscontrollv3.model.Responsible

import com.example.businesscontrollv3.model.Transaction

data class TransactionProjection (

    @Embedded
    val transaction: Transaction,
    @Relation(entity= Transaction::class,

        parentColumn = "transactionId",
        entityColumn = "idTransaction"
    )
    val responsible: Responsible
)