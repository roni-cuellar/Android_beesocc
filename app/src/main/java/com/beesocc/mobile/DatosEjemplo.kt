package com.beesocc.mobile

// Información temporal para enseñar las pantallas. No utiliza Internet ni una base de datos.
object DatosEjemplo {
    var liga = "Liga BetPlay"
    var temporada = "2025"
    var descripcion = "Campeonato de fútbol"
    var vueltas = 1
    val equipos = mutableListOf("Águilas FC", "Leones FC", "Tigres FC", "Halcones FC")
    val ciudades = mutableListOf("Popayán", "Cali", "Neiva", "Pereira")
    data class Jugador(val nombre: String, val dorsal: Int, val posicion: String, val equipo: String)
    val jugadores = listOf(
        Jugador("Carlos Pérez", 10, "Delantero", "Águilas FC"),
        Jugador("Daniel Torres", 8, "Mediocampista", "Águilas FC"),
        Jugador("Juan Rojas", 1, "Portero", "Águilas FC"),
        Jugador("Mateo Ruiz", 9, "Delantero", "Leones FC"),
        Jugador("Andrés López", 5, "Defensa", "Leones FC"),
        Jugador("Samuel Díaz", 7, "Extremo", "Tigres FC"),
        Jugador("Luis Gómez", 6, "Mediocampista", "Tigres FC"),
        Jugador("Santiago Mora", 11, "Delantero", "Halcones FC")
    )
    data class Partido(val jornada: Int, val local: String, val visitante: String,
                       val resultado: String, val estado: String, val fecha: String)
    val partidos = listOf(
        Partido(1, "Águilas FC", "Leones FC", "VS", "Programado", "Sábado · 3:00 p. m."),
        Partido(1, "Tigres FC", "Halcones FC", "2 - 1", "Finalizado", "Viernes · 5:00 p. m."),
        Partido(2, "Águilas FC", "Tigres FC", "VS", "Programado", "Próximo sábado · 4:00 p. m."),
        Partido(2, "Leones FC", "Halcones FC", "VS", "Programado", "Próximo domingo · 2:00 p. m."),
        Partido(3, "Águilas FC", "Halcones FC", "VS", "Programado", "Jornada 3 · pendiente"),
        Partido(3, "Leones FC", "Tigres FC", "VS", "Programado", "Jornada 3 · pendiente")
    )
}
