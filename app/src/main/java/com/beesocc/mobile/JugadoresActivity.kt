package com.beesocc.mobile

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import android.view.View

class JugadoresActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jugadores)
        prepararBarra()
        val selector = findViewById<Spinner>(R.id.selectorEquipo)
        selector.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, DatosEjemplo.equipos)
        selector.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                mostrarJugadores(DatosEjemplo.equipos[position])
            }
        }
    }

    private fun mostrarJugadores(equipo: String) {
        val lista = findViewById<LinearLayout>(R.id.listaJugadores)
        lista.removeAllViews()
        DatosEjemplo.jugadores.filter { it.equipo == equipo }.forEach { jugador ->
            val fila = LayoutInflater.from(this).inflate(R.layout.item_jugador, lista, false)
            fila.findViewById<TextView>(R.id.dorsalJugador).text = jugador.dorsal.toString()
            fila.findViewById<TextView>(R.id.nombreJugador).text = jugador.nombre
            fila.findViewById<TextView>(R.id.posicionJugador).text = jugador.posicion
            lista.addView(fila)
        }
        if (lista.childCount == 0) {
            val mensaje = TextView(this)
            mensaje.text = "Aún no hay jugadores en este equipo."
            mensaje.setPadding(12, 22, 12, 22)
            lista.addView(mensaje)
        }
    }
}
