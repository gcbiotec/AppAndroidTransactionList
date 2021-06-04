package com.example.businesscontrollv3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.businesscontrollv3.BusinessControllV3
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.databinding.ActivityAccountBinding
import com.example.businesscontrollv3.databinding.ActivityResponsibleBinding
import com.example.businesscontrollv3.utils.SpinnerListener
import com.example.businesscontrollv3.viewmodel.AccountViewModel
import com.example.businesscontrollv3.viewmodel.AccountViewModelFactory
import com.example.businesscontrollv3.viewmodel.ActivityViewModel
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity : AppCompatActivity() {

    //val accountActivity = AccountActivity()
    val accountViewModel:AccountViewModel by viewModels{
        AccountViewModelFactory(application  as BusinessControllV3)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_account)

        val binding: ActivityAccountBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_account)
        binding.accountViewModel = accountViewModel

//        accountTypespinner.onItemSelectedListener = SpinnerListener.onItemSelectedListener { accountViewModel::selectAccountType }
//        responsibleTypespinner.onItem
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun saveResponsible(view: View) {
        this.accountViewModel.save()
        this.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

}