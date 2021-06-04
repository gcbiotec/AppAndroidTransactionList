package com.example.businesscontrollv3.viewmodel


import android.content.Context
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.businesscontrollv3.model.Transaction
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
    var description: String? = null

    @Bindable
    var idResponsible: Int = 0

    @Bindable
    var idAccount: Int = 0

    @Bindable
    var incomeType: IncomeType? = null

    @Bindable
    var expenseCategoryType: ExpenseCategoryTypeEnum? = null

    @Bindable
    var destinationAccount: Int? = null

    val gson: Gson = Gson()

    fun save(context: Context): () -> Unit {

        return {

            viewModelScope.launch {
                val transaction = Transaction(value = 0.0)
                transactionRepository.save(transaction)
            }

            transactionsList.observeForever {
                Toast.makeText(context, "Transação salva: $it", Toast.LENGTH_LONG).show()
            }
        }
    }

}



//val transactionList = transactionTypeEnum.type