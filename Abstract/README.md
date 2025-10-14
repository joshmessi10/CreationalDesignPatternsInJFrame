# 🧬 Patrón Abstract

## Descripción del Proceso: Creación de pagos

En una empresa de transporte y mensajería, el proceso de gestión de pagos es esencial para asegurar que todas las transacciones. Cada pago puede realizarse por diferentes medios, como efectivo o tarjeta, y aunque ambos comparten la misma información base (identificador, monto y registro de transacción), su comportamiento y validación varían según el tipo de pago. Por ejemplo: 

Pago en efectivo: se realiza directamente en ventanilla y no requiere verificación bancaria. 

Pago con tarjeta: debe incluir validación de número de tarjeta, autorización del banco y registro digital del movimiento. 

Ambos tipos de pago pertenecen al mismo proceso, pero difieren en su creación y gestión interna. Este escenario hace que el patrón Abstract Factory sea el más adecuado, ya que permite crear familias de objetos relacionados (pagos de distintos tipos) sin especificar su clase concreta, garantizando flexibilidad, escalabilidad y mantenibilidad del sistema. 

**Ventajas:**
- Desacoplamiento: separa la lógica de creación de objetos del código principal del sistema. 
- Extensibilidad: se pueden agregar fácilmente nuevos tipos de pagos (por ejemplo, pago por transferencia o código QR) sin modificar la estructura existente. 
- Consistencia: garantiza que los objetos creados pertenecen a la misma familia o contexto (todos son tipos de “Pago”). 
- Mantenibilidad: simplifica la actualización de la lógica de creación o validación de cada tipo de pago. 

---

## Diagrama de Clases

<img width="538" height="324" alt="image" src="https://github.com/user-attachments/assets/7449710c-77ef-4753-a396-dd6d2771e47a" />

<img width="690" height="747" alt="image" src="https://github.com/user-attachments/assets/3a88dd71-c9ab-4594-a0ca-b9fcd1d8480c" />


---

## Implementación
<img width="267" height="347" alt="image" src="https://github.com/user-attachments/assets/64b7a88d-b3eb-4c43-8e81-a732afc34718" />

<img width="268" height="354" alt="image" src="https://github.com/user-attachments/assets/6d2b5191-f0c2-4765-94b2-495717b19f57" />

<img width="315" height="418" alt="image" src="https://github.com/user-attachments/assets/31e9bb85-ff54-4822-b7c3-0dbacf76b547" />

<img width="307" height="396" alt="image" src="https://github.com/user-attachments/assets/2c13e0e1-c4a9-4e77-84a9-1c224173c886" />
