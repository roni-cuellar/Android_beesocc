package com.beesocc.mobile

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class EstadisticasActivity : BaseActivity() {
    private val datos = mapOf(
        "Goleadores" to listOf("Carlos Pérez" to 5, "Mateo Ruiz" to 3, "Samuel Díaz" to 2),
        "Asistencias" to listOf("Daniel Torres" to 4, "Luis Gómez" to 2, "Juan Rojas" to 1),
        "Amarillas" to listOf("Andrés López" to 3, "Santiago Mora" to 2, "Mateo Ruiz" to 1),
        "Rojas" to listOf("Andrés López" to 1),
        "Faltas" to listOf("Tigres FC" to 8, "Leones FC" to 6),
        "Equipos" to listOf("Águilas FC" to 10, "Leones FC" to 7, "Tigres FC" to 4)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)
        prepararBarra()
        val botones = mapOf(
            R.id.btnGoles to "Goleadores", R.id.btnAsistencias to "Asistencias",
            R.id.btnAmarillas to "Amarillas", R.id.btnRojas to "Rojas",
            R.id.btnFaltas to "Faltas", R.id.btnEquiposStats to "Equipos"
        )
        botones.forEach { (id, titulo) ->
            findViewById<Button>(id).setOnClickListener { mostrar(titulo) }
        }
        mostrar("Goleadores")
    }

    private fun mostrar(titulo: String) {
        findViewById<TextView>(R.id.tituloEstadistica).text = titulo
        val lista = findViewById<LinearLayout>(R.id.listaEstadisticas)
        lista.removeAllViews()
        datos[titulo].orEmpty().forEachIndexed { i, par ->
            val fila = LayoutInflater.from(this).inflate(R.layout.item_estadistica, lista, false)
            fila.findViewById<TextView>(R.id.rangoEstadistica).text = "#${i + 1}"
            fila.findViewById<TextView>(R.id.nombreEstadistica).text = par.first
            fila.findViewById<TextView>(R.id.totalEstadistica).text = par.second.toString()
            lista.addView(fila)
        }
    }
}
