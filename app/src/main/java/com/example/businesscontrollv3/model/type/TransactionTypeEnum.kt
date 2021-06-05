package com.example.businesscontrollv3.model.type

enum class TransactionTypeEnum(val type:String) {

    EXPENSE("Despesa"),
    INCOME("Receita"),
    TRANSFER("Transferencia");

    companion object {

        fun fromString(string: String): TransactionTypeEnum? {
            return values().find {
                it.type == string
            }
        }
    }

}