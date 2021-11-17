package com.example.retrofitexample2.model

data class Note(
    var id_usuario: Int,
    var nombre_creador: String,
    var fecha: String,
    var hora: String,
    var titulo: String,
    var contenido: String
)
