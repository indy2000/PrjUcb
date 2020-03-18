package com.projetoucb.prjucb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class FragMenuPrincipal : Fragment()
{
    private var btnMenuUsuario: ImageView? = null
    private var btnConsultaReserva: ImageView? = null
    private var btnReservarLab: ImageView? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_main_menu, container, false)

        btnMenuUsuario = rootView.findViewById(R.id.principal_iv_usuarios)
        btnReservarLab = rootView.findViewById(R.id.principal_iv_reservar)
        btnConsultaReserva = rootView.findViewById(R.id.principal_iv_consultar_reserva)

        btnMenuUsuario?.setOnClickListener(btnListener(1))

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun btnListener(codBtn: Int): View.OnClickListener
    {

        return View.OnClickListener {
            activity?.let {
                act ->
                when(codBtn)
                {
                    1 ->
                    {
                        act.title = getString(R.string.gerir_usuarios)
                        act.supportFragmentManager.beginTransaction()
                            .setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_in_left)
                            .addToBackStack("MENU_PRINCIPAL")
                            .replace(R.id.principal_container, FragGerirUsarios(),"GERIR_USUARIOS")
                            .commit()
                    }
//                2 -> intent = Intent(this@Principal, FragCriarReserva::class.java)
//                3 -> intent = Intent(this@Principal, FragConsultarReserva::class.java)
                    else -> null
                }
            }

//            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FragCadastroUsuario()).commit()
        }
    }
}