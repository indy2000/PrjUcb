package com.projetoucb.prjucb.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.projetoucb.data.entity.Usuario
import com.projetoucb.prjucb.R

class ItensUsuariosAdapter(private val lista: List<Usuario>, private val context: Context): RecyclerView.Adapter<ItensUsuariosAdapter.HolderUsuarios>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderUsuarios {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.cardview_gerir_usuarios, parent, false)
        return HolderUsuarios(itemLista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: HolderUsuarios, position: Int) {
        holder.tvNome.text = String.format(context.getString(R.string.campo_nome), lista[position].nome)
        holder.tvEmail.text = String.format(context.getString(R.string.campo_email), lista[position].email)
        val campo_matUser = if(lista[position].tipo_usuario == 1) context.getString(R.string.campo_matricula)
        else context.getString(R.string.campo_usuario)
        holder.tvUsuario.text = String.format(campo_matUser, lista[position].usuario)
        val tipo_usuario = if(lista[position].tipo_usuario == 1) context.getString(R.string.professor)
        else context.getString(R.string.administrador)
        holder.tvTipoUsuario.text = String.format(context.getString(R.string.campo_tipo_usuario), tipo_usuario)

        holder.cv_gerir_usuarios.setOnLongClickListener(View.OnLongClickListener {
            Toast.makeText(context, lista[position].id.toString(), Toast.LENGTH_SHORT).show()
         true
        })
    }

    inner class HolderUsuarios(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var tvNome = itemView.findViewById<TextView>(R.id.cardview_gerir_usuarios_nome)
        var tvEmail = itemView.findViewById<TextView>(R.id.cardview_gerir_usuarios_email)
        var tvUsuario = itemView.findViewById<TextView>(R.id.cardview_gerir_usuarios_usuario)
        var tvTipoUsuario = itemView.findViewById<TextView>(R.id.cardview_gerir_usuarios_tipo_usuario)
        var cv_gerir_usuarios = itemView.findViewById<CardView>(R.id.cardview_gerir_usuarios)
    }
}