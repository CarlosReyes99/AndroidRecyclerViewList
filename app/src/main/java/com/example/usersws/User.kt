package com.example.usersws

data class User(val id: Long, var nombre: String, var apellido: String, var url: String){

    fun getFullName(): String= "$nombre $apellido"
}