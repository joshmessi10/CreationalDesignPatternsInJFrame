# 🧬 Patrón Abstract

## Descripción del Proceso: Creación de Planes de Mantenimiento

En una empresa de transporte y mensajería, la creación de facturas o tiquetes es un proceso esencial para registrar las ventas de servicios. Cada factura debe incluir información clave como el cliente, destino, valor del servicio, cantidad y un identificador único que permita su trazabilidad dentro del sistema. Sin embargo, el proceso de creación no es idéntico para todos los casos. Existen diferentes tipos de tiquetes (por ejemplo, tiquete de pasajero y tiquete de paquete) que comparten ciertos datos, pero difieren en la forma en que se generan y administran. 

El Abstract Factory Method permite crear objetos de diferentes tipos de tiquetes sin acoplar directamente la lógica de construcción dentro del controlador. 
 Cada tipo de tiquete (paquete o pasajero) tiene su propia fábrica concreta, que se encarga de instanciar el objeto adecuado a partir de los mismos parámetros base. 

**Ventajas:**
- Facilita la extensión del sistema (por ejemplo, agregar un nuevo tipo de tiquete en el futuro sin modificar el controlador).
- Promueve la separación de responsabilidades entre el controlador y la lógica de creación.
- Reduce el acoplamiento y mejora la mantenibilidad del código.

---

## Diagrama de Clases

<img width="622" height="427" alt="image" src="https://github.com/user-attachments/assets/577e84ff-b00c-4e92-9868-bc5d851e1060" />

<img width="780" height="386" alt="image" src="https://github.com/user-attachments/assets/3e4a3383-7a96-4aa7-8d46-5ec64f572e14" />

---

## Implementación
<img width="469" height="602" alt="image" src="https://github.com/user-attachments/assets/56efdf97-1693-4453-ba7f-4c5f78fd7ac3" />

<img width="465" height="652" alt="image" src="https://github.com/user-attachments/assets/0e07c413-7e2f-4be5-8a65-9c078798c918" />

<img width="458" height="651" alt="image" src="https://github.com/user-attachments/assets/5bbccae2-6bb3-4710-8963-2486ebce55c7" />

<img width="458" height="646" alt="image" src="https://github.com/user-attachments/assets/317d39d0-157f-45d9-b986-7459795bcb4d" />
