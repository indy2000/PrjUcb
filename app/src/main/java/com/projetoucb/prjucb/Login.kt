package com.projetoucb.prjucb

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerFrameLayout
import com.projetoucb.prjucb.utils.Prefs
import com.projetoucb.prjucb.utils.Tema

class Login : AppCompatActivity() {

    private var btnEntrar: Button? = null
    private var tvVersao: TextView? = null
    private var ivLogo: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(Tema.setTema(Prefs.getTema(this@Login)))
        setContentView(R.layout.activity_login)

        btnEntrar = findViewById(R.id.login_btnEntrar)
        tvVersao = findViewById(R.id.login_tvVersao)
        ivLogo = findViewById(R.id.login_ivLogo)

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

    override fun onBackPressed() {

    }
}
