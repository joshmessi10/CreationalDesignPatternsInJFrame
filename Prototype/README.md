# 🧬 Patrón Prototype

El patrón **Prototype** permite crear nuevos objetos **clonando instancias existentes** en lugar de construirlas desde cero. Es ideal cuando la creación de un objeto es costosa, compleja o cuando necesitamos múltiples objetos similares con pequeñas variaciones.

En este repositorio, se muestra un ejemplo del patrón Prototype aplicado a **la gestión de planes de mantenimiento en una empresa de transporte**, donde los planes para distintos vehículos comparten estructuras similares y solo varían algunos parámetros.

---

## Descripción del Proceso: Creación de Planes de Mantenimiento

La empresa gestiona una flota diversa de vehículos: buses, camionetas, vans, motocicletas y camiones. Cada tipo de vehículo requiere planes de mantenimiento específicos, definidos según su uso (urbano, intermunicipal, carga, pasajeros) y sus características técnicas (kilometraje, sistema de frenos, tipo de motor, combustible, etc.).

Muchos de estos planes comparten estructuras muy similares. Por ejemplo, casi todos incluyen revisiones de motor, frenos, llantas y cambios de aceite, pero con variaciones en frecuencia o profundidad.  

En lugar de definir cada plan desde cero, es más eficiente **clonar un plan existente y modificar solo los parámetros que cambian**. Este escenario es perfecto para el patrón Prototype, que permite crear nuevos objetos copiando otros ya existentes, reduciendo esfuerzo y garantizando coherencia en la información.

**Ventajas:**
- Evita duplicación de código.  
- Facilita la creación rápida de planes similares.  
- Mantiene consistencia en los datos base del mantenimiento.  

---

## Aplicación del Patrón

**Interfaz Prototype:**  
Define el contrato para la clonación.  

- `clone(): Prototype`  

**Clase Base – PlanMantenimiento:**  
Contiene todos los atributos comunes:  
- `id: String`  
- `vehiculoTipo: String`  
- `periodicidadKm: Integer`  
- `checklist: List<CheckItem>`  
- `repuestos: List<Repuesto>`  
- `notasTecnicas: String`  

**Métodos principales:**  
- `PlanMantenimiento(PlanMantenimiento otro)`  
- `clone(): PlanMantenimiento`  
- `ajustarPeriodicidad(Integer km)`  
- `agregarCheckItem(CheckItem item)`  
- `eliminarCheckItem(String nombre)`  
- `agregarRepuesto(Repuesto repuesto)`  
- `eliminarRepuesto(String nombre)`  
- `actualizarNotas(String notas)`  

**Subclases concretas:**  
Permiten especializar la clonación según el tipo de vehículo.

- **PlanMantenimientoBus**  
  - Atributos adicionales:  
    - `revisionFrenosAire: Boolean`  
    - `revisionTacografo: Boolean`  
  - Métodos:  
    - `verificarFrenosAire()`  
    - `verificarTacografo()`  
    - `clone(): PlanMantenimientoBus`  

- **PlanMantenimientoMinivan**  
  - Atributos adicionales:  
    - `revisionSuspensionLigera: Boolean`  
  - Métodos:  
    - `verificarSuspensionLigera()`  
    - `clone(): PlanMantenimientoMinivan`  

Estas subclases sobrescriben `clone()` para incluir los atributos adicionales de cada tipo de vehículo y garantizar que la copia sea completa y coherente.

---

## Diagrama de Clases

<img width="649" height="732" alt="image" src="https://github.com/user-attachments/assets/c5618262-f783-4f6a-8d80-c8d2a282a2e7" />

<img width="766" height="921" alt="image" src="https://github.com/user-attachments/assets/03b65b9b-ca83-4714-ba0b-58aa8d4a7e73" />

---

## Implementación

<img width="408" height="631" alt="image" src="https://github.com/user-attachments/assets/0722051c-55f4-454f-aa81-2091edf4547e" />

<img width="416" height="651" alt="image" src="https://github.com/user-attachments/assets/d932704c-e24d-4070-83ec-9b6245fb06a7" />

<img width="470" height="644" alt="image" src="https://github.com/user-attachments/assets/6427ab29-1ff4-40b8-8b4a-b59686b23b2f" />

<img width="476" height="646" alt="image" src="https://github.com/user-attachments/assets/082c7a08-b070-4740-8b62-23f1caea1c6c" />

<img width="921" height="376" alt="image" src="https://github.com/user-attachments/assets/25113391-c82d-4d17-9fd3-564609058acf" />



