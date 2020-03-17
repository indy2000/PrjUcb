package com.projetoucb.prjucb

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.animation.Animation
import android.widget.ImageView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.get

class Principal : AppCompatActivity() {

    private var btnMenuUsuario: ImageView? = null
    private var btnConsultaReserva: ImageView? = null
    private var btnReservarLab: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(findViewById(R.id.custom_toolbar))

        btnMenuUsuario = findViewById(R.id.principal_iv_usuarios)
        btnReservarLab = findViewById(R.id.principal_iv_reservar)
        btnConsultaReserva = findViewById(R.id.principal_iv_consultar_reserva)

        btnMenuUsuario?.setOnClickListener(btnListener(1))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        return super.onCreateOptionsMenu(menu)
    }

    private fun btnListener(codBtn: Int): View.OnClickListener
    {
        return View.OnClickListener {
            when(codBtn)
            {
                1 -> supportFragmentManager.beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_in_left)
                    .replace(R.id.principal_layout, FragCadastroUsuario())
                    .commit()
//                2 -> intent = Intent(this@Principal, FragCriarReserva::class.java)
                //3 -> intent = Intent(this@Principal, FragConsultarReserva::class.java)
            }
            //supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FragCadastroUsuario()).commit()
        }
    }
}
