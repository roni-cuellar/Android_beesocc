package com.beesocc.mobile

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class PartidosActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partidos)
        prepararBarra()
        val lista = findViewById<LinearLayout>(R.id.listaPartidos)
        DatosEjemplo.partidos.forEach { partido ->
            val fila = LayoutInflater.from(this).inflate(R.layout.item_partido, lista, false)
            fila.findViewById<TextView>(R.id.jornadaPartido).text = "Jornada ${partido.jornada}"
            fila.findViewById<TextView>(R.id.estadoPartido).text = partido.estado
            fila.findViewById<TextView>(R.id.localPartido).text = partido.local
            fila.findViewById<TextView>(R.id.visitantePartido).text = partido.visitante
            fila.findViewById<TextView>(R.id.marcadorPartido).text = partido.resultado
            fila.findViewById<TextView>(R.id.fechaPartido).text = partido.fecha
            fila.setOnClickListener { AlertDialog.Builder(this).setTitle("Jornada ${partido.jornada}")
                .setMessage("${partido.local} vs ${partido.visitante}\n${partido.fecha}\n${partido.estado}")
                .setPositiveButton("Cerrar", null).show() }
            lista.addView(fila)
        }
        findViewById<Button>(R.id.btnVerCalendario).setOnClickListener { abrir(CalendarioActivity::class.java) }
    }
}
