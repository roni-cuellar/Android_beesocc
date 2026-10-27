package com.beesocc.mobile

import android.app.Activity
import android.content.Intent
import android.widget.TextView

// Reutiliza la navegación entre los módulos deportivos.
open class BaseActivity : Activity() {
    fun abrir(destino: Class<out Activity>) {
        startActivity(Intent(this, destino))
    }

    fun prepararBarra() {
        findViewById<TextView>(R.id.btnVolverLigas)?.setOnClickListener {
            abrir(MisLigasActivity::class.java)
        }
        findViewById<TextView>(R.id.navResumen)?.setOnClickListener { abrir(DashboardActivity::class.java) }
        findViewById<TextView>(R.id.navEquipos)?.setOnClickListener { abrir(EquiposActivity::class.java) }
        findViewById<TextView>(R.id.navPartidos)?.setOnClickListener { abrir(PartidosActivity::class.java) }
        findViewById<TextView>(R.id.navTabla)?.setOnClickListener { abrir(TablaActivity::class.java) }
    }
}
