package com.example.businesscontrollv3.model.projection

import androidx.room.Embedded
import androidx.room.Relation
import com.example.businesscontrollv3.model.Responsible

import com.example.businesscontrollv3.model.Transaction

data class TransactionProjection {

    @Embedded
    val transaction: Transaction,
    @Relation(
        parentColumn = "responsibleId",
        entityColumn = "idResponsible"
    )
    val responsible: Responsible
}