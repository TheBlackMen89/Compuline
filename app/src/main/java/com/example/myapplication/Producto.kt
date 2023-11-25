package com.example.myapplication

import java.io.Serializable

data class Producto(
    var marca: String,
    var descripcion: String,
    var precio: String,
    var imagen: Int
): Serializable