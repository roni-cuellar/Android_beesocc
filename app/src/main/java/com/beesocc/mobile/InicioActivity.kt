package com.beesocc.mobile

import android.os.Bundle
import android.widget.Button
import android.widget.ScrollView

class InicioActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        findViewById<Button>(R.id.btnComenzar).setOnClickListener { abrir(LoginActivity::class.java) }
        findViewById<Button>(R.id.btnRegistroInicio).setOnClickListener { abrir(RegistroActivity::class.java) }
        findViewById<Button>(R.id.btnExplorar).setOnClickListener {
            findViewById<ScrollView>(R.id.scrollInicio)?.smoothScrollTo(0, 800)
        }
    }
}
