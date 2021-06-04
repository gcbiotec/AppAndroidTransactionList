package com.example.businesscontrollv3.repository

import android.content.Context
import androidx.annotation.WorkerThread
import com.example.businesscontrollv3.infra.database.ResponsibleDAO
import com.example.businesscontrollv3.model.Responsible
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ResponsibleRepository(private val responsibleDAO: ResponsibleDAO) {

    fun getResponsibles() = responsibleDAO.getAllResponsibles()

    @WorkerThread
    suspend fun save(responsible: Responsible){
        responsibleDAO.save(responsible)

    }
}

//    val gson: Gson = Gson()
//
//    private fun getSharedPref() =
//            context.getSharedPreferences("RESPONSIBLES_KEY", Context.MODE_PRIVATE)?:
//            throw Exception("KEY INVALID")
//
//    fun getResponsibles(): MutableList<Responsible>{
//        val sharedPref = getSharedPref()
//
//        //Pegar arquivo para leitura e escrita
//        val stringResponsibles = sharedPref.getString(RESPONSIBLES_KEY, "")
//
//        val type: Type = object : TypeToken<List<Responsible>>() {}.type
//
//        return if (stringResponsibles.isNullOrEmpty())
//            mutableListOf()
//        else
//            gson.fromJson(stringResponsibles, type)
//    }

//    suspend fun save(responsible: Responsible) {
//        val sharedPref = getSharedPref()
//
//        val responsibles = getResponsibles()

//        val type: Type = object : TypeToken<List<Responsible>>() {}.type
//        val responsibles: MutableList<Responsible> = if (stringResponsibles.isNullOrEmpty()) mutableListOf()
//        else gson.fromJson(stringResponsibles, type)
//        val responsible = Responsible(name)

//        responsibles.add(responsible)
//
//        with(sharedPref.edit()){
//            putString(RESPONSIBLES_KEY, gson.toJson(responsibles))
//            commit()
//        }
//    }
//    companion object{
//        const val RESPONSIBLES_KEY = "responsibles"
//    }
