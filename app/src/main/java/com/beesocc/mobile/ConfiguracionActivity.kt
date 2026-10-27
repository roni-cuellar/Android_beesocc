package com.beesocc.mobile

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class ConfiguracionActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)
        prepararBarra()
        val selector = findViewById<Spinner>(R.id.selectorVueltas)
        selector.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,
            listOf("1 vuelta", "2 vueltas"))
        selector.setSelection(DatosEjemplo.vueltas - 1)
        findViewById<Button>(R.id.btnGuardarConfig).setOnClickListener {
            DatosEjemplo.vueltas = selector.selectedItemPosition + 1
            Toast.makeText(this, "Configuración actualizada", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
