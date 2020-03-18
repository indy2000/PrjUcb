package com.projetoucb.prjucb

import android.content.Intent
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
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
import com.projetoucb.prjucb.utils.Prefs
import com.projetoucb.prjucb.utils.Tema

class Principal : AppCompatActivity() {

    private lateinit var layoutDrawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(Tema.setTema(Prefs.getTema(this@Principal)))
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.principal_container, FragMenuPrincipal(), "MENU_PRINCIPAL").commit()
        layoutDrawer = findViewById<DrawerLayout>(R.id.principal_drawerLayout)
        layoutDrawer.setScrimColor(ContextCompat.getColor(this@Principal, R.color.colorPrimaryDark))

        this.setToolbar()

        val navigationDrawer = findViewById<NavigationView>(R.id.principal_navigationLateral)
        navigationDrawer.setNavigationItemSelectedListener(navigationListener())
        val switch = navigationDrawer.menu.findItem(R.id.principal_lateral_tema)
            .actionView.findViewById<Switch>(R.id.principal_lateral_tema)
            switch.isChecked = Tema.setSwitchChecked(this@Principal)
        navigationDrawer.menu.findItem(R.id.principal_lateral_tema)
            .title = String.format(getString(R.string.tema, Tema.getNomeTema(this@Principal)))
        switch.setOnCheckedChangeListener(switchListerner(navigationDrawer.menu.findItem(R.id.principal_lateral_tema)))
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
                R.id.principal_lateral_gerir ->
                {
                    title = getString(R.string.gerir_usuarios)
                    supportFragmentManager.beginTransaction()
                        .setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_in_left)
                        .addToBackStack("MENU_PRINCIPAL")
                        .replace(R.id.principal_container, FragGerirUsarios())
                        .commit()
                }
//                R.id.principal_lateral_tema ->
//                {
//                    var switch = findViewById<Switch>(R.id.principal_lateral_tema)
//                    if(!switch.isChecked)
//                    {
//                        switch.isChecked = true
//                        Prefs.setTema(this@Principal,"noturno")
//                        finish()
//                        startActivity(Intent(applicationContext,Principal::class.java))
//                        item.title = String.format(getString(R.string.tema), getString(R.string.noturno))
//
//                    }
//                    else
//                    {
//                        switch.isChecked = false
//                        Prefs.setTema(this@Principal,"claro")
//                        finish()
//                        startActivity(Intent(applicationContext,Principal::class.java))
//                        item.title = String.format(getString(R.string.tema), getString(R.string.claro))
//                    }
//
//                    //switch.setOnCheckedChangeListener(switchListerner(item))
//                }
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

    private fun switchListerner(item: MenuItem) = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->

        if(isChecked)
        {
            Prefs.setTema(this@Principal,"noturno")
            finish()
            startActivity(Intent(applicationContext,Principal::class.java))
            item.title = String.format(getString(R.string.tema), getString(R.string.noturno))

        }
        else
        {
            Prefs.setTema(this@Principal,"claro")
            finish()
            startActivity(Intent(applicationContext,Principal::class.java))
            item.title = String.format(getString(R.string.tema), getString(R.string.claro))
        }
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount > 0)
        {
            supportFragmentManager.popBackStack()
        }
        if(layoutDrawer.isDrawerOpen(GravityCompat.START)) layoutDrawer.closeDrawer(GravityCompat.START)
    }
}
