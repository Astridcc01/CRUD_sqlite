package com.example.com.hito

class Transacciones {
    var id: Int
    var nombre: String
    var concepto: String
    var precio: Int

    internal constructor(id: Int,nombre: String, concepto: String, precio: Int) {
        this.id=id
        this.nombre = nombre
        this.concepto = concepto
        this.precio = precio
    }
}