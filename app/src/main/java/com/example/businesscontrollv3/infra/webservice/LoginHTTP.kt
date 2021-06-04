package com.example.businesscontrollv3.infra.webservice

import com.example.businesscontrollv3.model.Login
import com.example.businesscontrollv3.model.User
import com.example.businesscontrollv3.model.Result
import com.google.gson.Gson
import java.io.InputStreamReader
import java.io.Reader
import java.net.HttpURLConnection
import java.net.URL

object LoginHTTP {

    private const val loginUrl = "https://business-controll-backend.herokuapp.com/v1/login"

    private val gson: Gson = Gson()

    suspend fun doLogin(login : Login): Result<User> {
    val url = URL(loginUrl)

        (url.openConnection() as? HttpURLConnection)?.run {
            requestMethod = "POST"
            setRequestProperty("Content-Type", "application/json; utf-8")
            setRequestProperty("Accept", "application/json")
            doOutput = true
            outputStream.write(gson.toJson(login).toByteArray())
            val reader: Reader = InputStreamReader(inputStream, "utf-8")
            val user = gson.fromJson(reader, User::class.java)
            return Result.Success(user)
        }
            return Result.Error(Exception("Não foi possível acessar a página por falta de conexão"))
    }
  }