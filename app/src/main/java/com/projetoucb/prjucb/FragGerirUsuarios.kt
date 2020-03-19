package com.projetoucb.prjucb

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.projetoucb.data.entity.Usuario
import com.projetoucb.prjucb.adapters.ItensUsuariosAdapter
import com.projetoucb.prjucb.utils.Utils


class FragGerirUsarios: Fragment()
{
    private lateinit var fabCadastrar: FloatingActionButton
    private var recyclerView: RecyclerView? = null
    private lateinit var dialog: AlertDialog

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
//            activity?.let { act ->
//                act.title = getString(R.string.cadastro_usuario)
//                act.supportFragmentManager.beginTransaction()
//                    .setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_in_left)
//                    .addToBackStack("GERIR_USUARIOS")
//                    .replace(R.id.principal_container,FragCadastroUsuario(),"CADASTRO_USUARIO")
//                    .commit()
//            }
            val fragment = LinearLayout.inflate(context, R.layout.fragment_cadastro_usuario, null)
            dialog = AlertDialog.Builder(context!!).create()
            dialog.setView(fragment)
            dialog.setTitle(getString(R.string.cadastro_usuario))
            dialog.setCancelable(false)
            dialog.show()
            fragment.findViewById<Button>(R.id.cadastro_usuario_btnVoltar)
                .setOnClickListener(View.OnClickListener { dialog.dismiss() })
            fragment.findViewById<Button>(R.id.cadastro_usuario_btnCadastrar)
                .setOnClickListener(View.OnClickListener {
                    var tipo_usuario: Int?
                    var matricula: String?
                    var nome: String?
                    var email: String?
                    try {
                        if(fragment.findViewById<Spinner>(R.id.cadastro_usuario_spnTipoUsuario).selectedItemPosition != 0)
                            tipo_usuario = fragment.findViewById<Spinner>(R.id.cadastro_usuario_spnTipoUsuario).selectedItemPosition
                        else throw Exception(getString(R.string.critica_tipoUsuario))

                        if(!fragment.findViewById<EditText>(R.id.cadastro_usuario_edtUsuario).text.toString().isNullOrEmpty())
                            matricula = fragment.findViewById<EditText>(R.id.cadastro_usuario_edtUsuario).text.toString()
                        else throw Exception(getString(R.string.critica_obrigatorioUsuario))

                        if(!fragment.findViewById<EditText>(R.id.cadastro_usuario_edtNome).text.toString().isNullOrEmpty())
                            nome = fragment.findViewById<EditText>(R.id.cadastro_usuario_edtNome).text.toString()
                        else throw Exception(getString(R.string.critica_obrigatorioNome))

                        if(!fragment.findViewById<EditText>(R.id.cadastro_usuario_edtEmail).text.toString().isNullOrEmpty())
                            email = fragment.findViewById<EditText>(R.id.cadastro_usuario_edtEmail).text.toString()
                        else throw Exception(getString(R.string.critica_obrigatorioEmail))


                        var usuario = Usuario()
                        usuario.tipo_usuario = tipo_usuario
                        usuario.usuario = matricula
                        usuario.nome = nome
                        usuario.email = email

                        dialog.dismiss()
                        Utils.dialogoNeutro(context!!, "Usuário criado com sucesso!", "OK")


                    }
                    catch (e: Exception)
                    {
                        when(e.message)
                        {
                            getString(R.string.critica_tipoUsuario) ->
                            {
//                                val dialogErro = AlertDialog.Builder(context!!).create()
//                                dialogErro.setMessage(getString(R.string.critica_tipoUsuario))
//                                dialogErro.setButton(AlertDialog.BUTTON_NEUTRAL, getString(R.string.ok), DialogInterface.OnClickListener { dialog, which ->
//                                    dialogErro.dismiss()
//                                })
//                                dialogErro.show()
                                context?.let {
                                    Utils.dialogoNeutro(it, getString(R.string.critica_tipoUsuario), getString(R.string.ok))
                                }

                            }
                            getString(R.string.critica_obrigatorioUsuario) ->
                                fragment.findViewById<EditText>(R.id.cadastro_usuario_edtUsuario)
                                    .error = getString(R.string.critica_obrigatorioUsuario)

                            getString(R.string.critica_obrigatorioNome) ->
                                fragment.findViewById<EditText>(R.id.cadastro_usuario_edtNome)
                                    .error = getString(R.string.critica_obrigatorioNome)

                            getString(R.string.critica_obrigatorioEmail) ->
                                fragment.findViewById<EditText>(R.id.cadastro_usuario_edtEmail)
                                    .error = getString(R.string.critica_obrigatorioEmail)
                        }
                    }
                })
        }
    }
}