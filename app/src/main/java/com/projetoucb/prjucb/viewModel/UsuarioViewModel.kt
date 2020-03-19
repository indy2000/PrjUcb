package com.projetoucb.prjucb.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.projetoucb.data.entity.Usuario
import com.projetoucb.prjucb.utils.Retorno
import com.projetoucb.repo.repository.UsuarioRepository
import io.reactivex.Maybe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class UsuarioViewModel(app: Application): AndroidViewModel(app)
{
    var usuarioLiveData: MutableLiveData<Retorno<List<Usuario>>> = MutableLiveData()

    fun getAllUsuarios(context: Context) = GlobalScope.launch(Dispatchers.IO)
    {
        UsuarioRepository(context).getAllUsuarios().subscribe({ success ->

            val retorno = Retorno<List<Usuario>>()
            retorno.id = 1
            retorno.obj = success

            GlobalScope.launch(Dispatchers.Main)
            {
                usuarioLiveData.value = retorno
            }
        }, { exception ->

            val retorno = Retorno<List<Usuario>>()
            retorno.id = 1
            retorno.obj = null
            retorno.exception = exception

            GlobalScope.launch(Dispatchers.Main)
            {
                usuarioLiveData.value = retorno
            }
        }).dispose()
    }

    fun insertUsuario(context: Context, usuario: Usuario): Boolean
    {
        try {
            GlobalScope.launch(Dispatchers.IO)
            {
                UsuarioRepository(context).inserirUsuario(usuario)
            }
            return true
        }
        catch (e: Exception)
        {
            return false
        }
    }

    fun removerUsuario(context: Context, userId: Int): Boolean
    {
        try {
            GlobalScope.launch(Dispatchers.IO)
            {
                UsuarioRepository(context).removerUsuario(userId)
            }
            return true
        }
        catch (e: Exception)
        {
            return false
        }
    }
}