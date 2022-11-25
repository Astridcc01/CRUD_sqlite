package com.example.com.hito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn_sesion = findViewById<Button>(R.id.btn_sesion)
        val cajaUsuario = findViewById<EditText>(R.id.et_usuario)
        val cajaPw = findViewById<EditText>(R.id.et_pw)

        btn_sesion.setOnClickListener(){

            var usuario:String=cajaUsuario.text.toString()
            var pw:String=cajaPw.text.toString()

            if (usuario.isEmpty() or pw.isEmpty()){
                Toast.makeText(this@Login,"Campo/s vacío/s",Toast.LENGTH_SHORT).show()
            }  else if(usuario.isNullOrBlank() or pw.isNullOrBlank()){
                Toast.makeText(this@Login,"Error de tipo de dato/s",Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this@Login,"Inciando sesión",Toast.LENGTH_SHORT).show()
                val intent: Intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}