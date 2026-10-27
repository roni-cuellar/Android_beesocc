package com.beesocc.mobile

import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CrearLigaActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_liga)
        prepararBarra()
        findViewById<Button>(R.id.btnGuardarLiga).setOnClickListener {
            val nombre = findViewById<EditText>(R.id.campoNombreLiga)
            val temporada = findViewById<EditText>(R.id.campoTemporada)
            when {
                nombre.text.isBlank() -> nombre.error = "Escribe el nombre"
                temporada.text.isBlank() -> temporada.error = "Escribe la temporada"
                else -> {
                    DatosEjemplo.liga = nombre.text.toString().trim()
                    DatosEjemplo.temporada = temporada.text.toString().trim()
                    DatosEjemplo.descripcion = findViewById<EditText>(R.id.campoDescripcion).text.toString()
                    abrir(MisLigasActivity::class.java)
                }
            }
        }
        findViewById<Button>(R.id.btnCancelar).setOnClickListener { finish() }
    }
}
