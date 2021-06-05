package com.example.businesscontrollv3.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.businesscontrollv3.BR
import com.example.businesscontrollv3.model.Account
import com.example.businesscontrollv3.model.Responsible
import com.example.businesscontrollv3.model.type.AccountTypeEnum
import com.example.businesscontrollv3.repository.AccountRepository
import com.example.businesscontrollv3.repository.ResponsibleRepository
import kotlinx.android.synthetic.main.item_transaction.view.*
import kotlinx.coroutines.launch

class AccountViewModel(
    private val accountRepository: AccountRepository,
    private val responsibleRepository: ResponsibleRepository
) : BaseViewModel() {

    val accountList = accountRepository.getAccounts().asLiveData()

    lateinit var responsibleList: List<Responsible>

    @Bindable
    var name: String = ""

    @Bindable
    var balance: String = ""

    @Bindable
    var accountTypes = AccountTypeEnum.values().map { accountTypeEnum -> accountTypeEnum.type }

    @Bindable
    var selectedAccountTypePosition: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.selectedAccountTypePosition)
        }

    var accountTypePosition: Int = 0

    @Bindable
    var responsibleNames: List<String> = emptyList()
        set(value) {
            field = value
            notifyPropertyChanged(BR.responsibleNames)
        }

    @Bindable
    var selectedResponsiblePosition: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.selectedResponsiblePosition)
        }

    var responsiblePosition: Int = 0

    @Bindable
    var errorMessage: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.errorMessage)
        }

    init {
        val account = accountRepository.selectedAccount
        if (account != null) {
            this.name = account.name
            this.balance = account.balance.toString()
            this.selectedAccountTypePosition = account.accountType.ordinal
        }

        responsibleRepository.getResponsibles().asLiveData().observeForever {
            responsibleNames = it.map { responsible -> responsible.name }
            responsibleList = it
            if (account != null) {
                this.selectedResponsiblePosition = responsibleList.indexOfFirst {
                        responsible -> responsible.idResponsible == account.responsibleId
                }
            }
        }
    }

    fun save() {
        if (formIsValid()) {
            viewModelScope.launch {
                val accountType = AccountTypeEnum.values()[accountTypePosition]
                val responsible = responsibleList[responsiblePosition]
                val account = if (accountRepository.selectedAccount != null) {
                    accountRepository.selectedAccount!!.name = name
                    accountRepository.selectedAccount!!.balance = balance.toDouble()
                    accountRepository.selectedAccount!!.responsibleId = responsible.idResponsible!!
                    accountRepository.selectedAccount!!.accountType = accountType
                    accountRepository.selectedAccount!!
                } else {
                    Account(name, balance.toDouble(), responsible.idResponsible!!, accountType)
                }

                accountRepository.save(account)
            }
        } else {
            this.errorMessage = "Formulário inválido, confira os campos antes de prosseguir"
        }
    }

    fun formIsValid() : Boolean {
        return name.isNotBlank() && balance.isNotBlank()
    }

    fun selectAccountType(position: Int) {
        accountTypePosition = position
    }

    fun selectResponsible(position: Int) {
        responsiblePosition = position
    }

    fun deleteAccount(account: Account) = viewModelScope.launch {
        accountRepository.deleteAccount(account)
    }

    fun selectedAccount(account: Account) {
        accountRepository.selectedAccount = account
    }

    fun cleanSelectedAccount() {
        accountRepository.selectedAccount = null
    }
}