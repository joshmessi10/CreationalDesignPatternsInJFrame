# 🚀 Patrones de Diseño Creacionales

Los **patrones de diseño creacionales** se enfocan en la **forma en que se crean los objetos**, buscando flexibilidad, reutilización y desacoplamiento entre la creación de un objeto y su uso. Estos patrones son esenciales en proyectos donde la creación de objetos puede ser compleja, costosa o requiere distintos niveles de configuración. 💡

En este repositorio se muestran **ejemplos de implementación de cada patrón** aplicados al **análisis de una empresa transportadora de pasajeros y mensajería/paquetería**, mostrando cómo estos patrones ayudan a modelar y gestionar los diferentes planes de mantenimiento y servicios de la empresa. 🚌📦✉️

---

## 1️⃣ Singleton
El patrón **Singleton** garantiza que una clase tenga **una única instancia** y proporciona un punto de acceso global a ella.  
- **Uso típico:** Control de acceso a recursos compartidos, manejo de configuración global, conexiones a bases de datos.  
- **Ventaja:** Evita múltiples instancias innecesarias. ✅  
- **Desventaja:** Puede ser problemático para pruebas unitarias y multihilo si no se implementa correctamente. ⚠️  

---

## 2️⃣ Factory Method (Método de Fábrica)
El **Factory Method** define una interfaz para crear objetos, pero permite que las subclases decidan qué clase instanciar.  
- **Uso típico:** Cuando una clase no puede anticipar el tipo de objetos que debe crear. 🎯  
- **Ventaja:** Desacopla la creación de objetos de su uso. 🔄  
- **Desventaja:** Puede aumentar la complejidad al agregar muchas subclases. ⚡  

---

## 3️⃣ Abstract Factory (Fábrica Abstracta)
El patrón **Abstract Factory** permite crear **familias de objetos relacionados** sin especificar sus clases concretas.  
- **Uso típico:** Interfaces gráficas que deben soportar múltiples estilos o plataformas. 🖥️📱  
- **Ventaja:** Asegura consistencia entre productos de la misma familia. ✨  
- **Desventaja:** Dificulta la introducción de nuevos tipos de productos. 🧩  

---

## 4️⃣ Builder (Constructor)
El patrón **Builder** separa la construcción de un objeto complejo de su representación, permitiendo crear diferentes representaciones paso a paso.  
- **Uso típico:** Construcción de documentos, configuraciones complejas de objetos, objetos con múltiples parámetros opcionales. 📄🛠️  
- **Ventaja:** Simplifica la creación de objetos complejos. ✅  
- **Desventaja:** Requiere más código y clases adicionales. ⚠️  

---

## 5️⃣ Prototype (Prototipo)
El patrón **Prototype** permite crear nuevos objetos **copiando un objeto existente**, en lugar de crearlo desde cero.  
- **Uso típico:** Clonación de objetos con configuraciones complejas o costosas de crear. 🧬  
- **Ventaja:** Evita repetir código de inicialización y facilita la creación de objetos similares. 🔄  
- **Desventaja:** Puede ser complicado si los objetos contienen referencias a otros objetos que requieren clonación profunda. 🌀  

---

## ✅ Resumen Visual

| Patrón           | Propósito                                 | Ventaja Principal             |
|-----------------|-------------------------------------------|------------------------------|
| Singleton        | Una única instancia global                 | Evita instancias duplicadas ✅ |
| Factory Method   | Delegar la creación a subclases           | Desacopla creación y uso 🔄   |
| Abstract Factory | Crear familias de objetos relacionados    | Coherencia entre productos ✨ |
| Builder          | Construir objetos complejos paso a paso   | Simplifica objetos complejos ✅|
| Prototype        | Clonar objetos existentes                 | Facilita duplicación 🔄       |

---

## 👥 Autores

- **Josh Sebastián López Murcia**  
- **María Alejandra Vargas Vázquez**
