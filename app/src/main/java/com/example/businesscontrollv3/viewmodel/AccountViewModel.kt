package com.example.businesscontrollv3.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.businesscontrollv3.BR
import com.example.businesscontrollv3.model.Account
import com.example.businesscontrollv3.model.type.AccountTypeEnum
import com.example.businesscontrollv3.repository.AccountRepository
import com.example.businesscontrollv3.repository.ResponsibleRepository
import kotlinx.android.synthetic.main.item_transaction.view.*
import kotlinx.coroutines.launch

class AccountViewModel(
    private val accountRepository: AccountRepository,
    private val responsibleRepository: ResponsibleRepository
) : BaseViewModel() {

    val accountList = this.accountRepository.getAccounts().asLiveData()

    @Bindable
    var name: String = ""
//        set(value) {
//            field = value
//            notifyPropertyChanged(BR.name)
//        }

    @Bindable
    var balance: String = ""
//        set(value) {
//            field = value
//            notifyPropertyChanged(BR.balance)
//        }

    @Bindable
    var accountTypes = AccountTypeEnum.values().map { accountTypeEnum -> accountTypeEnum.type }

    @Bindable
    var selectedAccountTypePosition: Int = 0
//        set(value) {
//            field = value
//            notifyPropertyChanged(BR.selectedAccountTypePosition)
//        }
    @Bindable
    var responsibleId: Int = 0

    @Bindable
    var responsibleNames: List<String> = emptyList()
        set(value) {
            field = value
            notifyPropertyChanged(BR.responsibleNames)
        }
    init {
        responsibleRepository.getResponsibles().asLiveData().observeForever() {
            responsibleNames = it.map { responsible -> responsible.name }
        }
    }


    fun save() {
        viewModelScope.launch {
            val account = Account(
                name,
                balance.toDouble(),
                responsibleId,
                accountTypeEnum = AccountTypeEnum.DEBITO
            )
            accountRepository.save(account)
        }
    }

    fun formIsValid(): Boolean {
        return name.isNotBlank() && balance.isNotBlank()
        return true
    }
}
//        return if (name.isNotBlank()) {
//            Toast.makeText(context, "Salvando $name", Toast.LENGTH_LONG).show()
//
//            var accountEnum = AccountTypeEnum.fromString(accountType)
//
//            val accountResponsible =
//                responsibleRepository.getResponsibles().asLiveData().value!!.find {
//                    it.name == responsible
//                }
//
//            val account =
//                Account(name, balance, accountResponsible!!.idResponsible2!!, accountEnum!!)
//
//            viewModelScope.launch {
//                accountRepository.save(responsible)
//            }
//
//            allResponsibles.observeForever {
//                Toast.makeText(context, "Usuarios salvos: $it", Toast.LENGTH_LONG).show()
//            }
//            true
//        } else {
//            Toast.makeText(context, "Não pode ser vazio", Toast.LENGTH_LONG).show()
//            false
//        }