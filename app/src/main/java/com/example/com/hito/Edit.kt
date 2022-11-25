package com.example.com.hito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Edit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        val botonEdit: Button =findViewById(R.id.btn_edit)
        val cajaID: EditText=findViewById(R.id.et_id_mod)
        val cajaNombreMod: EditText =findViewById(R.id.et_nombre_nuevo)
        val cajaConceptoMod: EditText =findViewById(R.id.et_concepto_mod)
        val cajaPrecioMod: EditText =findViewById(R.id.et_precio_mod)
        botonEdit.setOnClickListener(){

            var id:String=cajaID.text.toString()
            var nombre:String=cajaNombreMod.text.toString()
            var concepto:String=cajaConceptoMod.text.toString()
            var precio:String=cajaPrecioMod.text.toString()

            var dataBase:DbHelper= DbHelper(this)

            if (id.isEmpty() or nombre.isEmpty() or concepto.isEmpty() or precio.isEmpty()){
                Toast.makeText(this@Edit,"Campo/s vacío/s",Toast.LENGTH_SHORT).show()
            }  else if(nombre.isNullOrBlank() or concepto.isNullOrBlank() or precio.isNullOrBlank()){
                Toast.makeText(this@Edit,"Error de tipo de dato/s",Toast.LENGTH_SHORT).show()
            }  else {
                Toast.makeText(this@Edit,"Transacción editada",Toast.LENGTH_SHORT).show()
                dataBase.upgradeTransaccion(id.toInt(),nombre,concepto,precio.toInt())
                val intent = Intent(this,MainActivity::class.java)
                this.startActivity(intent)
            }
        }

    }
}