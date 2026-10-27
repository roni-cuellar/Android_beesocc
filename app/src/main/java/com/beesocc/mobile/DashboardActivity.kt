package com.beesocc.mobile

import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DashboardActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        prepararBarra()
        findViewById<TextView>(R.id.nombreDashboard).text = DatosEjemplo.liga
        findViewById<TextView>(R.id.numeroEquipos).text = DatosEjemplo.equipos.size.toString()
        findViewById<TextView>(R.id.numeroJugadores).text = DatosEjemplo.jugadores.size.toString()
        findViewById<TextView>(R.id.numeroPartidos).text = DatosEjemplo.partidos.size.toString()
        findViewById<Button>(R.id.btnEquipos).setOnClickListener { abrir(EquiposActivity::class.java) }
        findViewById<Button>(R.id.btnJugadores).setOnClickListener { abrir(JugadoresActivity::class.java) }
        findViewById<Button>(R.id.btnPartidos).setOnClickListener { abrir(PartidosActivity::class.java) }
        findViewById<Button>(R.id.btnCalendario).setOnClickListener { abrir(CalendarioActivity::class.java) }
        findViewById<Button>(R.id.btnTabla).setOnClickListener { abrir(TablaActivity::class.java) }
        findViewById<Button>(R.id.btnEstadisticas).setOnClickListener { abrir(EstadisticasActivity::class.java) }
        findViewById<Button>(R.id.btnConfigurar).setOnClickListener { abrir(ConfiguracionActivity::class.java) }
    }
}
