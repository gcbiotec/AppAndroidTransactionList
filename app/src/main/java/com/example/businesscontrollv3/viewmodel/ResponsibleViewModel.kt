package com.example.businesscontrollv3.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import com.example.businesscontrollv3.BR
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.businesscontrollv3.model.Responsible
import com.example.businesscontrollv3.repository.ResponsibleRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import java.lang.reflect.Type

class ResponsibleViewModel(private val responsibleRepository: ResponsibleRepository) :
    BaseViewModel(), Observable {

    val allResponsibles = this.responsibleRepository.getResponsibles().asLiveData()

    @Bindable
    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    val gson: Gson = Gson()

    fun save(context: Context): Boolean {

        return if (name.isNotBlank()) {
            Toast.makeText(context, "Salvando $name", Toast.LENGTH_LONG).show()
            val responsible = Responsible(name)

            viewModelScope.launch {
                responsibleRepository.save(responsible)
            }

            allResponsibles.observeForever {
                Toast.makeText(context, "Usuarios salvos: $it", Toast.LENGTH_LONG).show()
            }
            true
        } else {
            Toast.makeText(context, "Não pode ser vazio", Toast.LENGTH_LONG).show()
            false
        }
    }
}


//saveInContext(context)
//true
//        }else{
//            Toast.makeText(context, "Nome não pode ser vazio", Toast.LENGTH_LONG).show()
//            false
//        }
//    }
//    private val callbacks: PropertyChangeRegistry by lazy {
//        PropertyChangeRegistry()
//    }
//
//    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
//        callbacks.add(callback)
//    }
//
//    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
//        callbacks.remove(callback)
//    }
//
//    fun saveInContext(context:Context){
//        val sharedPref = context.getSharedPreferences("responsibles", Context.MODE_PRIVATE)?: return
//
//        val stringResponsibles = sharedPref.getString("responsibles", "")
//        val type: Type = object : TypeToken<List<Responsible>>() {}.type
//        val responsibles: MutableList<Responsible> = if (stringResponsibles.isNullOrEmpty()) mutableListOf()
//                                                      else gson.fromJson(stringResponsibles, type)
//
//        val responsible = Responsible(name)
//        responsibles.add(responsible)
//        with(sharedPref.edit()){
//            putString("responsibles", gson.toJson(responsibles))
//            commit()
//        }
//
//        Toast.makeText(context, "Usuarios salvos: $responsibles" , Toast.LENGTH_LONG).show()
//
//    }
//}