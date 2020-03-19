package com.projetoucb.repo.repository

import android.content.Context
import com.projetoucb.data.dao.AppDataBase
import com.projetoucb.data.dao.DataBase
import com.projetoucb.data.entity.Usuario
import io.reactivex.Maybe
import java.lang.Exception


class UsuarioRepository(val context: Context)
{
    fun getAllUsuarios(): Maybe<List<Usuario>>
    {
        return DataBase().getDataBase(context).UsuarioDao().selectAll()
    }

    fun inserirUsuario(usuario: Usuario)
    {
        DataBase().getDataBase(context).UsuarioDao().insert(usuario)
    }

    fun removerUsuario(id: Int)
    {
        DataBase().getDataBase(context).UsuarioDao().delete(id)
    }
}