package com.beesocc.mobile

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class CalendarioActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)
        prepararBarra()
        findViewById<Button>(R.id.btnConfigCalendario).setOnClickListener { abrir(ConfiguracionActivity::class.java) }
    }

    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.textoVueltas).text = "${DatosEjemplo.vueltas} vuelta(s) · ${3 * DatosEjemplo.vueltas} jornadas"
        val lista = findViewById<LinearLayout>(R.id.listaCalendario)
        lista.removeAllViews()
        for (vuelta in 0 until DatosEjemplo.vueltas) {
            for (jornada in 1..3) {
                val titulo = TextView(this)
                titulo.text = "Jornada ${jornada + vuelta * 3}"
                titulo.textSize = 18f
                titulo.setTextColor(getColor(R.color.verde_oscuro))
                titulo.setPadding(4, 18, 4, 10)
                lista.addView(titulo)
                DatosEjemplo.partidos.filter { it.jornada == jornada }.forEach { partido ->
                    val fila = LayoutInflater.from(this).inflate(R.layout.item_partido, lista, false)
                    fila.findViewById<TextView>(R.id.jornadaPartido).text = "Todos contra todos"
                    fila.findViewById<TextView>(R.id.estadoPartido).text = if (vuelta == 0) partido.estado else "Programado"
                    fila.findViewById<TextView>(R.id.localPartido).text = if (vuelta == 0) partido.local else partido.visitante
                    fila.findViewById<TextView>(R.id.visitantePartido).text = if (vuelta == 0) partido.visitante else partido.local
                    fila.findViewById<TextView>(R.id.marcadorPartido).text = if (vuelta == 0) partido.resultado else "VS"
                    fila.findViewById<TextView>(R.id.fechaPartido).text = if (vuelta == 0) partido.fecha else "Por programar"
                    lista.addView(fila)
                }
            }
        }
    }
}
