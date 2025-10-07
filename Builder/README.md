# 🏗️ Patrón Builder

El patrón **Builder** permite construir objetos complejos paso a paso, separando su construcción de su representación final. Es ideal cuando un objeto requiere múltiples pasos de configuración y se necesitan diferentes representaciones del mismo conjunto de datos.

En este repositorio, se presenta un ejemplo de uso del patrón Builder aplicado a **la planificación de rutas en una empresa de transporte y mensajería**, donde los mismos datos pueden generar distintos productos según el área de uso (operativa o gerencial).

---

## Descripción del Proceso: Planificación de Rutas

En una empresa de transporte y mensajería, la planificación de rutas es una de las tareas más críticas para la operación diaria. Cada viaje —sea de pasajeros o de carga— debe definirse en términos de paradas, horarios, distancias, vehículos asignados y tiempos estimados. Sin embargo, los objetivos y formatos de uso de esa información pueden variar según el área del sistema:

- **Área operativa:** necesita una ruta programada con todos los detalles para los conductores, despachadores y control de tráfico.  
- **Área administrativa o gerencial:** requiere un reporte de ruta que contenga los mismos datos base, pero resumidos, para análisis de eficiencia, cumplimiento y optimización.  

Ambos productos (la ruta programada y el reporte de ruta) comparten los mismos datos de origen, pero difieren en su forma final y en la intención de uso. Este escenario hace que el patrón Builder sea ideal, porque permite **separar la construcción de un objeto complejo de su representación final**, utilizando los mismos pasos de construcción para generar distintos resultados.

**Ventajas:**
- Facilita generar diferentes productos con el mismo flujo base de datos.  
- Permite la escalabilidad con la implementación de más builders.  
- Reutiliza el código de construcción, evitando duplicación.

---

## Aplicación del Patrón

**Director:**  
Coordina el proceso de construcción, definiendo los pasos que deben ejecutarse. Permite dos formas de construcción:  
- `construirRutaProgramada(builder)`  
- `construirReporteRuta(builder)`  

**Responsabilidades:**  
- Definir el flujo de pasos en orden.  
- No conocer los detalles internos de cómo cada builder implementa los métodos.  
- Delegar la construcción a los builders concretos.  

**Interface Builder:**  
Define las operaciones genéricas necesarias para construir los distintos tipos de rutas.  

- `reset()`  
- `agregarParadas(List<Parada> paradas)`  
- `asignarVehiculo(Vehiculo vehiculo)`  
- `definirConductor(Conductor conductor)`  
- `agregarRestricciones(List<String> restricciones)`  
- `configurarTarifas(Map<String, Double> tarifas)`  
- `calcularDistanciasRecorridas()`  
- `calcularTiemposEstimados()`  
- `obtenerResultado(): Object`  

**Concrete Builders:**  
Cada uno genera una representación específica del producto final.  

- **RutaProgramadaBuilder:**  
  - Produce un objeto `RutaProgramada` con toda la información operativa.  
  - Implementa todos los pasos definidos en la interfaz.  
  - Puede incluir métodos adicionales como validaciones de disponibilidad del vehículo o conductor.  

- **ReporteRutaBuilder:**  
  - Produce un objeto `ReporteRuta` con resúmenes estadísticos o informes gerenciales.  
  - Los métodos comunes generan datos, pero su resultado se presenta en un formato distinto.  

**Productos:**  
- `RutaProgramada`: contiene todos los datos operativos de la planificación.  
- `ReporteRuta`: contiene un resumen optimizado para presentación, exportación o impresión.  

---

## Diagrama de Clases

<img width="797" height="662" alt="image" src="https://github.com/user-attachments/assets/12ed5df4-ba73-40dc-8dee-9f19371687da" />

<img width="1160" height="921" alt="image" src="https://github.com/user-attachments/assets/8f937e39-7b1f-4cb5-89b7-e68f66500e0e" />

---

## Implementación

<img width="545" height="696" alt="image" src="https://github.com/user-attachments/assets/4513510f-27a2-4f95-b394-58fa56c84e0e" />

<img width="571" height="609" alt="image" src="https://github.com/user-attachments/assets/622a0d22-3c42-4202-ba44-f3b9498ce20f" />

<img width="703" height="953" alt="image" src="https://github.com/user-attachments/assets/c7d388fb-d9d4-442e-a2f6-5eb6ac7f589e" />

