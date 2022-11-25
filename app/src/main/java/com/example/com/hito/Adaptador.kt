package com.example.com.hito

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class Adaptador(val context: Context, val listTransacciones:ArrayList<Transacciones>,val db:DbHelper):
    RecyclerView.Adapter<TransaccionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransaccionViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_layout,parent,false)
        return TransaccionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransaccionViewHolder, position: Int) {
        val transaccion=listTransacciones[position]
        holder.tvId.text="ID: "+transaccion.id.toString()
        holder.tvNombre.text="Nombre: "+transaccion.nombre
        holder.tvConcepto.text="Concepto: "+transaccion.concepto
        holder.tvPrecio.text="Precio: "+transaccion.precio.toString()+"€"
        holder.imagenEditar.setOnClickListener(){
            val intent = Intent(context,Edit::class.java)
            context.startActivity(intent)
        }
        holder.imagenEliminar.setOnClickListener(){
            db.deleteTransaccion(transaccion.id)
            val intent = Intent(context,MainActivity::class.java)
            context.startActivity(intent)
            Toast.makeText(context,"Transacción eliminada", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
       return listTransacciones.size
    }

}//cierra Adaptador