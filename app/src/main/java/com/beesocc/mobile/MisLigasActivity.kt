package com.beesocc.mobile

import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MisLigasActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_ligas)
        prepararBarra()
        findViewById<TextView>(R.id.textoLiga).text = DatosEjemplo.liga
        findViewById<TextView>(R.id.textoTemporada).text = DatosEjemplo.temporada
        findViewById<TextView>(R.id.textoDescripcion).text = DatosEjemplo.descripcion
        findViewById<Button>(R.id.btnCrearLiga).setOnClickListener { abrir(CrearLigaActivity::class.java) }
        findViewById<Button>(R.id.btnAdministrar).setOnClickListener { abrir(DashboardActivity::class.java) }
        findViewById<Button>(R.id.btnSalir).setOnClickListener { abrir(InicioActivity::class.java) }
    }
}
