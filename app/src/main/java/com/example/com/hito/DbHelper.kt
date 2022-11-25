package com.example.com.hito

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context):SQLiteOpenHelper
    (context,"base.db",null,1) {

    companion object{
        private val TABLE="transaccion"

        private val ID="id"
        private val NOMBRE="nombre"
        private val CONCEPTO="concepto"
        private val PRECIO="precio"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val CREAR_TABLA_TRANSACCIONES = ("CREATE TABLE " + TABLE + "("+ ID
                + " INTEGER PRIMARY KEY" + " AUTOINCREMENT,"
                + NOMBRE + " TEXT," + CONCEPTO + " TEXT,"
                + PRECIO + " INTEGER" + ")")
        p0?.execSQL(CREAR_TABLA_TRANSACCIONES)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS " + TABLE)
        onCreate(p0)
    }

    fun addTransaccion(nombre: String,concepto : String, precio: Int){
        val db=this.writableDatabase
        val values=ContentValues()
        values.put(NOMBRE,nombre)
        values.put(CONCEPTO,concepto)
        values.put(PRECIO,precio)
        db.insert("transaccion",null,values)
    }

    fun upgradeTransaccion(id: Int,nombre: String,concepto : String, precio: Int){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(ID,id)
        values.put(NOMBRE,nombre)
        values.put(CONCEPTO,concepto)
        values.put(PRECIO,precio)
        db.update(
            "transaccion",
            values,
            ID + " = ?",
        arrayOf(id.toString())
        )
    }

    fun deleteTransaccion(id:Int){
        val db=this.writableDatabase
        db.delete(
            "transaccion",
            "$ID = ?",
            arrayOf(id.toString())
        )
    }

    fun viewTransaccion():ArrayList<Transacciones>{
        val sql = "select * from $TABLE"
        val db = this.writableDatabase
        val storeTransacciones =ArrayList<Transacciones>()
        val cursor = db.rawQuery(sql,null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(0).toInt()
                val nombre = cursor.getString(1)
                val concepto = cursor.getString(2)
                val precio = cursor.getString(3).toInt()
                storeTransacciones.add(Transacciones(id,nombre, concepto, precio))
            }
            while (cursor.moveToNext())
        }
        cursor.close()
        return storeTransacciones
    }

}//cierra clase DbHelper