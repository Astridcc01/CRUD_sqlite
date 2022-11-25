package com.example.com.hito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView=findViewById(R.id.rv)
        var dataBase:DbHelper=DbHelper(this)
        var transacciones=ArrayList<Transacciones>()
        transacciones=dataBase.viewTransaccion()
        dataBase.viewTransaccion()
        recyclerView.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=Adaptador(context,transacciones,dataBase)
        }

        val botonAdd:Button=findViewById(R.id.btn_add)

        val cajaNombre: EditText =findViewById(R.id.et_nombre)
        val cajaConcepto: EditText =findViewById(R.id.et_concepto)
        val cajaPrecio: EditText =findViewById(R.id.et_precio)

        botonAdd.setOnClickListener(){

            var nombre:String=cajaNombre.text.toString()
            var concepto:String=cajaConcepto.text.toString()
            var precio:String=cajaPrecio.text.toString()

            var dataBase:DbHelper= DbHelper(this)

            if (nombre.isEmpty() or concepto.isEmpty() or precio.isEmpty()){
                Toast.makeText(this@MainActivity,"Campo/s vacío/s",Toast.LENGTH_SHORT).show()
            } else if(nombre.isNullOrBlank() or concepto.isNullOrBlank() or precio.isNullOrBlank()){
                Toast.makeText(this@MainActivity,"Error de tipo de dato/s",Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this@MainActivity,"Transacción añadida",Toast.LENGTH_SHORT).show()
                dataBase.addTransaccion(nombre, concepto, precio.toInt())
                val intent = Intent(this,MainActivity::class.java)
                this.startActivity(intent)
            }
        }
    }
}