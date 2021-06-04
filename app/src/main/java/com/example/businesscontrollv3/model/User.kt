package com.example.businesscontrollv3.model

import com.google.gson.annotations.SerializedName

class User(
    @SerializedName("nome")
    val name: String,
    val email: String) {


}