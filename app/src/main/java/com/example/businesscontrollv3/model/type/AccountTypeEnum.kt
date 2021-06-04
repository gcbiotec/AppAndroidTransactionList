package com.example.businesscontrollv3.model.type



enum class AccountTypeEnum(val type: String) {
    DEBITO("Débito"),
    CREDITO("Crédito");

    companion object {

        fun fromString(string: String): AccountTypeEnum? {
            return values().find {
                it.type == string
            }
        }
    }
}
