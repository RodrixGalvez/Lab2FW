Lab 1 – RPG Character Sheet

var vit by remember { mutableIntStateOf(10) }
var dex by remember { mutableIntStateOf(10) }
var wis by remember { mutableIntStateOf(10) }
Uso de remember y mutableIntStateOf

Estado local reactivo

Re-composición automática al cambiar el estado

@Composable
fun StatRow(...)
Composables reutilizables

Separación de responsabilidades en UI

Column { ... }
Row { ... }
Card { ... }
Construcción de UI usando Column, Row y Card

Uso de padding y disposición lógica de elementos

Funcionalidades
Tres estadísticas del personaje:

-Vitality
-Dexterity
-Wisdom

Botón Roll para generar un valor aleatorio por estadística

Cálculo automático del Total Score

Mensajes condicionales:

  -Total < 30 → “Re-roll recommended!” (rojo)
  -Total ≥ 50 → “Godlike!” (dorado)



Lab 2 – Traffic Light Simulator

enum class Light { Red, Yellow, Green }
Uso de enum class para modelar estados finitos

var state by remember { mutableStateOf(Light.Red) }
Estado reactivo controlando la UI

LaunchedEffect(Unit) {
    while (true) {
        state = Light.Red
        delay(2000)
        state = Light.Green
        delay(2000)
        state = Light.Yellow
        delay(1000)
    }
}
LaunchedEffect(Unit) ejecutándose una sola vez

Coroutines con delay

Loop infinito controlado por el lifecycle del composable

if (state == Light.Red) Color.Red else Color.Gray
UI reactiva basada en el estado actual

Funcionalidades
Semáforo con tres luces:

  -Roja
  -Amarilla
  -Verde

Ciclo automático con tiempos realistas:

  -Rojo: 2s
  -Verde: 2s
  -Amarillo: 1s

Luces activas brillantes, inactivas en gris
UI centrada y estilizada simulando un semáforo real



