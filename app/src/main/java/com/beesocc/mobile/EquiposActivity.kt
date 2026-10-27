package com.beesocc.mobile

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class EquiposActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipos)
        prepararBarra()
        mostrarEquipos()
        findViewById<Button>(R.id.btnAnadirEquipo).setOnClickListener {
            val campo = EditText(this)
            campo.hint = "Nombre del equipo"
            campo.setPadding(24, 16, 24, 16)
            AlertDialog.Builder(this)
                .setTitle("Agregar equipo")
                .setView(campo)
                .setNegativeButton("Cancelar", null)
                .setPositiveButton("Agregar") { _, _ ->
                    if (campo.text.isNotBlank()) {
                        DatosEjemplo.equipos.add(campo.text.toString().trim())
                        DatosEjemplo.ciudades.add("Sin ciudad")
                        mostrarEquipos()
                    }
                }.show()
        }
    }

    private fun mostrarEquipos() {
        val lista = findViewById<LinearLayout>(R.id.listaEquipos)
        lista.removeAllViews()
        DatosEjemplo.equipos.forEachIndexed { i, equipo ->
            val fila = LayoutInflater.from(this).inflate(R.layout.item_equipo, lista, false)
            fila.findViewById<TextView>(R.id.inicialesEquipo).text = equipo.take(2).uppercase()
            fila.findViewById<TextView>(R.id.nombreEquipo).text = equipo
            fila.findViewById<TextView>(R.id.ciudadEquipo).text = DatosEjemplo.ciudades.getOrElse(i) { "" }
            lista.addView(fila)
        }
    }
}
