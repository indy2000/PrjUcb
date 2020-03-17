package com.projetoucb.prjucb

import android.content.Intent
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.view.animation.Animation
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Principal : AppCompatActivity() {

    private var btnMenuUsuario: ImageView? = null
    private var btnConsultaReserva: ImageView? = null
    private var btnReservarLab: ImageView? = null
    private lateinit var layoutDrawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutDrawer = findViewById<DrawerLayout>(R.id.principal_drawerLayout)
        layoutDrawer.setScrimColor(ContextCompat.getColor(this@Principal, R.color.colorPrimaryDark))

        this.setToolbar()

        val navigationDrawer = findViewById<NavigationView>(R.id.principal_navigationLateral)
        navigationDrawer.setNavigationItemSelectedListener(navigationListener())
        val cabecalho = navigationDrawer.inflateHeaderView(R.layout.navigation_cabecalho)
        val tvUsuario = cabecalho.findViewById<TextView>(R.id.cabecalho_tvUsuario)
        tvUsuario.text = "FULANO DA SILVA"
//        btnMenuUsuario = findViewById(R.id.principal_iv_usuarios)
//        btnReservarLab = findViewById(R.id.principal_iv_reservar)
//        btnConsultaReserva = findViewById(R.id.principal_iv_consultar_reserva)
//
//        btnMenuUsuario?.setOnClickListener(btnListener(1))
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
//                1 -> supportFragmentManager.beginTransaction()
//                    .setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_in_left)
//                    .replace(R.id.principal_layout, FragCadastroUsuario())
//                    .commit()
//                2 -> intent = Intent(this@Principal, FragCriarReserva::class.java)
                //3 -> intent = Intent(this@Principal, FragConsultarReserva::class.java)
            }
            //supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FragCadastroUsuario()).commit()
        }
    }
    private fun navigationListener() = NavigationView.OnNavigationItemSelectedListener {
            item ->
            findViewById<DrawerLayout>(R.id.principal_drawerLayout).closeDrawer(GravityCompat.START)
            when(item.itemId)
            {
                R.id.principal_lateral_tema ->
                {
                    var switch = findViewById<Switch>(R.id.principal_lateral_tema)
                    switch.setOnCheckedChangeListener(switchListerner())
                }
                R.id.principal_lateral_sair ->
                {
                    finish()
                    startActivity(Intent(this@Principal, Login::class.java))
                }
            }

        true
    }

    private fun setToolbar() {
        //region Toolbar
        val toolbar = findViewById<Toolbar>(R.id.custom_toolbar)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.elevation = 4f
        }

        supportActionBar?.hide()
        setSupportActionBar(toolbar)
        setTitle(R.string.principal)

        //region
        val toggle = ActionBarDrawerToggle(this, layoutDrawer, toolbar, 0, 0)
        toggle.isDrawerIndicatorEnabled = true
        toggle.toolbarNavigationClickListener = View.OnClickListener { layoutDrawer.openDrawer(GravityCompat.START) }
        toggle.syncState()
        //endregion

        //endregion
    }

    private fun switchListerner() = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->

        if(isChecked)
        {
            applicationContext.setTheme(R.style.AppThemeDark)
            findViewById<Switch>(R.id.principal_lateral_tema)
                .text = String.format(getString(R.string.tema), getString(R.string.noturno))
            finish()
            startActivity(Intent(applicationContext,Principal::class.java))

        }
        else
        {
            applicationContext.setTheme(R.style.AppTheme)
            findViewById<Switch>(R.id.principal_lateral_tema)
                .text = String.format(getString(R.string.tema), getString(R.string.claro))
            finish()
            startActivity(Intent(applicationContext,Principal::class.java))
        }
    }

    override fun onBackPressed() {
        if(layoutDrawer.isDrawerOpen(GravityCompat.START)) layoutDrawer.closeDrawer(GravityCompat.START)
    }
}
