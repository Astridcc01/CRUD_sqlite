package com.example.com.hito

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransaccionViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
    var tvId:TextView=itemView.findViewById(R.id.tv_id)
    var tvNombre:TextView=itemView.findViewById(R.id.tv_nombre)
    var tvConcepto:TextView=itemView.findViewById(R.id.tv_concepto)
    var tvPrecio:TextView=itemView.findViewById(R.id.tv_precio)
    var imagenEditar:ImageView=itemView.findViewById(R.id.editar)
    var imagenEliminar:ImageView=itemView.findViewById(R.id.eliminar)

}//cierra class