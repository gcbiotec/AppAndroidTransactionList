package com.example.businesscontrollv3.view

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.businesscontrollv3.BusinessControllV3
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.databinding.ActivityAccountBinding
import com.example.businesscontrollv3.viewmodel.*

class TransactionActivity : AppCompatActivity() {

    // val accountActivity = AccountActivity()
    //val transactionViewModel = TransactionViewModel()

    private val transactionViewModel: TransactionViewModel by viewModels {
        TransactionViewModelFactory(application as BusinessControllV3)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_transaction)

        val binding: ActivityAccountBinding = DataBindingUtil.setContentView(this, R.layout.item_transaction)
        binding.transactionViewModel = transactionViewModel

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    fun saveResponsible(view: View){
        transactionViewModel.save(applicationContext)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        return when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

}