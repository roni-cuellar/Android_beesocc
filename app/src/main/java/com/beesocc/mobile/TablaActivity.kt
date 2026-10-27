package com.beesocc.mobile

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView

class TablaActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabla)
        prepararBarra()
        val tabla = listOf(
            listOf("Águilas FC", "3", "+4", "7"),
            listOf("Leones FC", "3", "+2", "6"),
            listOf("Tigres FC", "3", "0", "4"),
            listOf("Halcones FC", "3", "-6", "0")
        )
        val lista = findViewById<LinearLayout>(R.id.listaTabla)
        tabla.forEachIndexed { i, filaDatos ->
            val fila = LayoutInflater.from(this).inflate(R.layout.item_tabla, lista, false)
            fila.findViewById<TextView>(R.id.posTabla).text = (i + 1).toString()
            fila.findViewById<TextView>(R.id.equipoTabla).text = filaDatos[0]
            fila.findViewById<TextView>(R.id.pjTabla).text = filaDatos[1]
            fila.findViewById<TextView>(R.id.dgTabla).text = filaDatos[2]
            fila.findViewById<TextView>(R.id.ptsTabla).text = filaDatos[3]
            lista.addView(fila)
        }
    }
}
