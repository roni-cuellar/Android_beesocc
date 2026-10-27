package com.beesocc.mobile

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RegistroActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        findViewById<Button>(R.id.btnCrearCuenta).setOnClickListener {
            val nombre = findViewById<EditText>(R.id.campoNombre)
            val correo = findViewById<EditText>(R.id.campoCorreo)
            val clave = findViewById<EditText>(R.id.campoClave).text.toString()
            val confirmar = findViewById<EditText>(R.id.campoConfirmar)
            when {
                nombre.text.isBlank() -> nombre.error = "Escribe tu nombre"
                !Patterns.EMAIL_ADDRESS.matcher(correo.text.toString()).matches() -> correo.error = "Correo no válido"
                clave.length < 4 -> findViewById<EditText>(R.id.campoClave).error = "Mínimo 4 caracteres"
                confirmar.text.toString() != clave -> confirmar.error = "Las contraseñas no coinciden"
                else -> abrir(MisLigasActivity::class.java)
            }
        }
        findViewById<TextView>(R.id.btnLogin).setOnClickListener { abrir(LoginActivity::class.java) }
        findViewById<TextView>(R.id.btnIrInicio).setOnClickListener { abrir(InicioActivity::class.java) }
    }
}
