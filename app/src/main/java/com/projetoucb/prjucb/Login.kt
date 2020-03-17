package com.projetoucb.prjucb

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {

    private var btnEntrar: Button? = null
    private var tvVersao: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnEntrar = findViewById(R.id.login_btnEntrar)
        tvVersao = findViewById(R.id.login_tvVersao)

        tvVersao?.text = String.format(getString(R.string.app_versao), BuildConfig.VERSION_NAME)

        btnEntrar?.setOnClickListener(btnEntrarListener())
    }
    private fun btnEntrarListener(): View.OnClickListener
    {
        return View.OnClickListener {
            val intent = Intent(this@Login, Principal::class.java )
            this.startActivity(intent)
        }
    }
}
