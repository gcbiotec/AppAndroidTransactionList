package com.example.businesscontrollv3.viewmodel


import android.content.Context
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR.expenseCategoryType
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.businesscontrollv3.BR
import com.example.businesscontrollv3.model.Transaction
import com.example.businesscontrollv3.model.type.AccountTypeEnum
import com.example.businesscontrollv3.model.type.ExpenseCategoryTypeEnum
import com.example.businesscontrollv3.model.type.IncomeType
import com.example.businesscontrollv3.model.type.TransactionTypeEnum
import com.example.businesscontrollv3.repository.TransactionRepository
import com.google.gson.Gson
import kotlinx.coroutines.launch
import java.util.*

abstract class TransactionViewModel(val transactionRepository: TransactionRepository) :
    BaseViewModel() {

     val transactionsList = this.transactionRepository.getTransactions().asLiveData()

    @Bindable
    lateinit var date: Calendar

    @Bindable
    var value: String? = null

    @Bindable
    var description: String? = null

    @Bindable
    var idResponsible: String? = null

    @Bindable
    var idAccount: String? = null

    @Bindable
    var incomeType: IncomeType? = null


    var transactionTypePosition: Int = 0
    var expenseTypePosition: Int = 0


//    @Bindable
//    var expenseCategoryType: ExpenseCategoryTypeEnum? = null

    @Bindable
    var expenseCategoryTypeList = ExpenseCategoryTypeEnum.values().map { expenseTypeEnum -> expenseTypeEnum.type }

    @Bindable
    var selectedExpenseCategoryTypePosition: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.selectedExpenseCategoryTypePosition)
        }
    @Bindable
    var transactionTypeList = TransactionTypeEnum.values().map { transactionTypeEnum -> transactionTypeEnum.type }

    @Bindable
    var selectedTransactionTypePosition: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.selectedExpenseCategoryTypePosition)
        }

    @Bindable
    var incomeTypeList = IncomeType.values().map { incomeTypeEnum -> incomeTypeEnum.type }

    @Bindable
    var selectedIncomeTypePosition: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.selectedExpenseCategoryTypePosition)
        }

    @Bindable
    var destinationAccount: String? = null

    val gson: Gson = Gson()

    fun save(context: Context): () -> Unit {

        return {
            //val accountType = AccountTypeEnum.values()[accountTypePosition]
            val transactionType = TransactionTypeEnum.values()[transactionTypePosition]
            val expenseCategoryType = ExpenseCategoryTypeEnum.values()[expenseTypePosition]

            viewModelScope.launch {
                val transaction = Transaction(
                    value,
                    description,
                    transactionType,
                    idResponsible,
                    incomeType,
                    expenseCategoryType,
                    destinationAccount,
                    idAccount
                    )
                transactionRepository.save(transaction)
            }

            transactionsList.observeForever {
                Toast.makeText(context, "Transação salva: $it", Toast.LENGTH_LONG).show()
            }
        }
    }

}



//val transactionList = transactionTypeEnum.type