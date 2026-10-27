# BEESOCC Mobile — Kotlin + XML

Proyecto **Android nativo** para abrir en Android Studio y presentar las pantallas de BEESOCC 2.0.

## Qué incluye

- **Inicio**, **Iniciar sesión**, **Registro**, **Mis Ligas**, **Crear liga**.
- **Dashboard**, **Equipos**, **Jugadores**, **Partidos**, **Calendario**, **Tabla de posiciones**, **Estadísticas** y **Configuración**.
- Cada pantalla tiene **Activity en Kotlin** y **layout XML**, con navegación por **Intents**.
- Identidad BEESOCC: verde `#16A34A`, verde oscuro `#0F3D2E`, fondos claros, imágenes oficiales.
- Datos de ejemplo cargados desde `DatosEjemplo.kt`. El formulario Crear liga y Agregar equipo modifican **únicamente variables en memoria**; al reiniciar la app se recuperan los datos iniciales.
- **No usa Laravel, Axios, MySQL, Internet, Sanctum ni autenticación real.** Las contraseñas no se guardan ni se comprueban. Adecuado para enseñar layouts y navegación local; no es una aplicación preparada para uso público.

## Abrir en Android Studio

1. Descomprime `BEESOCC_Mobile_AndroidStudio.zip`.
2. Abre Android Studio → **Open** → selecciona la carpeta `BEESOCC_Mobile_AndroidStudio` (la que contiene `settings.gradle.kts`).
3. Deja que Gradle sincronice el proyecto. Se necesita JDK 17 (Android Studio puede proporcionarlo) y Android SDK API 35.
4. Selecciona un emulador de teléfono, por ejemplo Pixel 6 o Pixel 7 con Android 13 o superior.
5. Pulsa **Run ▶** y selecciona `app`.

**Gradle:** El proyecto usa Android Gradle Plugin `8.7.3`, Kotlin `2.0.21` y Gradle `8.9`. Se incluye `gradle/wrapper/gradle-wrapper.properties` para indicar Gradle 8.9, pero no el archivo binario `gradle-wrapper.jar`. Android Studio puede gestionar la distribución de Gradle al importar el proyecto; si tu instalación exige el wrapper completo, genera sus archivos ejecutando `gradle wrapper --gradle-version 8.9` con Gradle instalado, o crea un proyecto nuevo de tipo Empty Views Activity y copia el contenido de `app/src/main` y los ajustes del módulo. Se requiere Internet para la primera sincronización de plugins.

## Ruta para exponer

1. Inicio → **Comenzar ahora**.
2. Iniciar sesión → escribe un correo válido y una contraseña cualquiera → **Mis ligas**.
3. Mis ligas → Administrar → Dashboard.
4. Dashboard → Equipos → Jugadores → Partidos → Calendario → Tabla → Estadísticas.
5. Mis ligas → Crear liga → guardar → regresar a Administrar.
6. Calendario → Cambiar configuración → escoger 2 vueltas.

## ¿Dónde está cada parte?

- `app/src/main/res/layout/activity_*.xml`: posiciones, textos y diseño visual de las pantallas.
- `app/src/main/java/com/beesocc/mobile/*Activity.kt`: clics, validación simple y navegación.
- `app/src/main/java/com/beesocc/mobile/DatosEjemplo.kt`: datos para la presentación.
- `app/src/main/res/values/colors.xml`: colores de la marca.
- `app/src/main/res/values/styles.xml`: estilos de botones, textos y campos.
- `app/src/main/res/drawable/`: fondos de tarjetas, botones, inputs.
- `app/src/main/res/drawable-nodpi/`: imágenes oficiales BEESOCC optimizadas sin cambios en su identidad.
- `app/src/main/AndroidManifest.xml`: registro de Activities y pantalla inicial.

## Conceptos para explicar

- **Activity**: una pantalla Android.
- **XML**: define la interfaz: ScrollView, LinearLayout, TextView, EditText, Button, ImageView y Spinner.
- **Kotlin**: escucha botones y cambia textos o datos en pantalla.
- **Intent**: abre otra Activity.
- **findViewById()**: relaciona un elemento XML con el código Kotlin.
- **LayoutInflater**: reutiliza una tarjeta XML para mostrar varios equipos, jugadores o partidos.

## Límites de esta entrega

Este paquete contiene el **código fuente**. El entorno de creación no tiene Android SDK ni Gradle instalados, por lo que **no se ha compilado ni ejecutado en emulador** aquí. La estructura XML fue revisada; realiza una sincronización y una prueba en Android Studio antes de presentarlo. Los números, marcadores, posiciones y estadísticas son ilustrativos y pueden no coincidir entre pantallas. No se conectan a la versión web.
