package com.projetoucb.prjucb.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class HolderUsuarios(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var tvNome = itemView.findViewById<TextView>(R.id.cardview_gerir_usuarios_nome)
        var tvEmail = itemView.findViewById<TextView>(R.id.cardview_gerir_usuarios_email)
        var tvUsuario = itemView.findViewById<TextView>(R.id.cardview_gerir_usuarios_usuario)
        var tvTipoUsuario = itemView.findViewById<TextView>(R.id.cardview_gerir_usuarios_tipo_usuario)
    }
}