package com.beesocc.mobile

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        findViewById<Button>(R.id.btnEntrar).setOnClickListener {
            val correo = findViewById<EditText>(R.id.campoCorreo).text.toString().trim()
            val clave = findViewById<EditText>(R.id.campoClave).text.toString()
            if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                findViewById<EditText>(R.id.campoCorreo).error = "Escribe un correo válido"
            } else if (clave.isBlank()) {
                findViewById<EditText>(R.id.campoClave).error = "Escribe tu contraseña"
            } else {
                // Solo navegación visual: no se almacenan ni comprueban contraseñas.
                abrir(MisLigasActivity::class.java)
            }
        }
        findViewById<TextView>(R.id.btnRegistro).setOnClickListener { abrir(RegistroActivity::class.java) }
        findViewById<TextView>(R.id.btnIrInicio).setOnClickListener { abrir(InicioActivity::class.java) }
    }
}
