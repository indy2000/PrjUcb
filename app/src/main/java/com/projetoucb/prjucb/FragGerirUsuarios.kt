package com.projetoucb.prjucb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.projetoucb.data.entity.Usuario
import com.projetoucb.prjucb.adapters.ItensUsuariosAdapter

class FragGerirUsarios: Fragment()
{
    private lateinit var fabCadastrar: FloatingActionButton
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_gerir_usuarios, container, false)

        fabCadastrar = rootView.findViewById(R.id.gerir_fab)
        fabCadastrar.setOnClickListener(fabListener())

        recyclerView = rootView.findViewById(R.id.gerir_recycle)
        val linearLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        recyclerView?.layoutManager = linearLayoutManager
        recyclerView?.setHasFixedSize(true)

        recyclerView?.adapter = ItensUsuariosAdapter(ArrayList(),context!!)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var usuario1 = Usuario()
        usuario1.nome = "Luiz Roberto Accacio"
        usuario1.email = "accacio@gmail.com"
        usuario1.usuario = "20145264"
        usuario1.tipo_usuario = 1

        var usuario2 = Usuario()
        usuario2.nome = "Marcia Gomes"
        usuario2.email = "mgomes@gmail.com"
        usuario2.usuario = "123456"
        usuario2.tipo_usuario = 2

        var listaUsuario = ArrayList<Usuario>()
        listaUsuario.add(usuario1)
        listaUsuario.add(usuario2)

        recyclerView?.adapter = ItensUsuariosAdapter(listaUsuario, context!!)
    }

    private fun fabListener(): View.OnClickListener
    {
        return View.OnClickListener {
            Toast.makeText(context,"Criar",Toast.LENGTH_SHORT).show()
            activity?.let { act ->
                act.title = getString(R.string.cadastro_usuario)
                act.supportFragmentManager.beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_in_left)
                    .addToBackStack("GERIR_USUARIOS")
                    .replace(R.id.principal_container,FragCadastroUsuario(),"CADASTRO_USUARIO")
                    .commit()
            }

        }
    }
}