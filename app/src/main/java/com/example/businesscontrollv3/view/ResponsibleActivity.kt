package com.example.businesscontrollv3.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.businesscontrollv3.BusinessControllV3
import com.example.businesscontrollv3.DataBinderMapperImpl
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.databinding.ActivityResponsibleBinding
import com.example.businesscontrollv3.viewmodel.ResponsibleViewModel
import com.example.businesscontrollv3.viewmodel.ResponsibleViewModelFactory

class ResponsibleActivity : AppCompatActivity() {

//    private val responsibleViewModel : ResponsibleViewModel by lazy {
//        val factory = ResponsibleViewModelFactory(application as BusinessControllV3)
//        ViewModelProvider(this, factory)
//                .get(ResponsibleViewModel::class.java)
//    }

    private val responsibleViewModel: ResponsibleViewModel by viewModels {
        ResponsibleViewModelFactory(application as BusinessControllV3)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_responsible)

        val binding: ActivityResponsibleBinding = DataBindingUtil.setContentView(this, R.layout.activity_responsible)
        binding.responsibleViewModel = responsibleViewModel

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

     fun saveResponsible(view: View){
        if(responsibleViewModel.save(applicationContext)) {
            finish()
        }
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