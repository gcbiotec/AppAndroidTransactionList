package com.example.businesscontrollv3.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.databinding.Bindable

class ActivityViewModel : BaseViewModel(){

    @Bindable
    var name: String = ""

    @Bindable
    var value: Double = 0.0

    @Bindable
    var responsavel: String = ""

    @Bindable
    var tipoConta: String = ""


    fun save(context: Context) {

        if(name.isNotBlank()){
            Toast.makeText(context,"Salvando $name", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context, "Nome não pode ser vazio", Toast.LENGTH_LONG).show()
        }
    }
}