package com.example.businesscontrollv3.model.projection

import androidx.room.Embedded
import androidx.room.Relation
import com.example.businesscontrollv3.model.Account
import com.example.businesscontrollv3.model.Responsible

data class AccountProjection(
    @Embedded
    val account: Account,
    @Relation(entity= Account::class,
        parentColumn = "responsibleId",
        entityColumn = "idResponsible"
    )
    val responsible: Responsible
)
