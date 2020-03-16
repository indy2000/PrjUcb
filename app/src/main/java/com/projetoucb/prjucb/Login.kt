package com.projetoucb.prjucb

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.facebook.shimmer.BuildConfig

class Login : AppCompatActivity() {

    private var btnEntrar: Button? = null
    private var tvVersao: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnEntrar = findViewById(R.id.login_btnEntrar)
        tvVersao = findViewById(R.id.login_tvVersao)

        tvVersao?.text = BuildConfig.VERSION_NAME

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
