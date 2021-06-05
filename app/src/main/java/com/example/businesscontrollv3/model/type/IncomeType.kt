package com.example.businesscontrollv3.model.type

enum class IncomeType(val type: String ) {

    SALARIO("Salario"),
    POUPANÇA("Poupança"),
    TRANSFERENCIA("Transferencia");

    companion object {

        fun fromString(string: String): TransactionTypeEnum? {
            return TransactionTypeEnum.values().find {
                it.type == string
            }
        }
    }


}