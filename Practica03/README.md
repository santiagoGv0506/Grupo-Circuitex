## ¿Por qué el lenguaje de máquina es importante para definir la arquitectura computacional?


El lenguaje de máquina es fundamental para definir la arquitectura computacional porque es el único idioma que realmente entienden las computadoras a nivel más bajo. La arquitectura computacional se refiere al diseño y la estructura de un sistema informático, que incluye componentes como la unidad central de procesamiento (CPU), la memoria, el bus de datos, etc.

El lenguaje de máquina consiste en una serie de instrucciones binarias que la CPU puede ejecutar directamente. Estas instrucciones están codificadas en un formato específico que representa operaciones simples, como sumar dos números o mover datos de un lugar a otro en la memoria. Cada arquitectura de CPU tiene su propio conjunto de instrucciones de máquina.


![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/97885177/33c0cc81-9882-4b28-a107-6dc329b147c9)



## ¿Qué diferencia ven entre arquitectura computacional, arquitectura de software y arquitectura del sistema?

La arquitectura computacional se enfoca en el diseño y la disposición física de los componentes internos de una computadora, como la CPU, la memoria RAM, los dispositivos de almacenamiento y los buses de datos. Por otro lado, la arquitectura de software se refiere a la estructura y organización de los programas y sistemas de software en una computadora, incluyendo el sistema operativo, las aplicaciones y sus interacciones. Finalmente, la arquitectura del sistema comprende tanto la organización interna del sistema operativo, como el kernel y los servicios asociados, así como la integración y coordinación de hardware y software para cumplir con los objetivos y requisitos del sistema informático en su conjunto.




##  ¿La arquitectura computacional o la arquitectura del sistema no tiene en cuenta igualmente la arquitectura de software?

En nuestra opinión, la arquitectura de software sí es tenida en cuenta por la arquitectura del sistema, dando que dentro del sistema se contempla el software que se va a realizar para poder darle un uso significativo a la arquitectura de hardware, implementando no solamente maneras de trabajar y crear cosas nuevas, sino que brinda la sinergia para que el hardware y el software trabajen en conjunto y den vida a todas las herramientas tecnológica conocidas, tales como, el pc, celular, tableta, etc.



# Componentes

## CPU

La CPU (Unidad Central de Procesamiento) es el componente central de la computadora que ejecuta instrucciones y realiza operaciones aritméticas y lógicas en los datos. La CPU está diseñada para ejecutar un conjunto específico de instrucciones definidas por el lenguaje de ensamblaje que se está utilizando en el proyecto, en este caso, el "Lenguaje Hack".

En el proyecto Nand2tetris, la CPU se construye utilizando puertas lógicas básicas, como NAND, AND, OR, y se describe en un archivo llamado CPU.hdl. Este archivo proporciona una descripción detallada de cómo se conectan estas puertas lógicas para formar los componentes básicos de la CPU, como la unidad de control, la unidad aritmético lógica (ALU) y los registros.

La CPU se encarga de ejecutar las instrucciones almacenadas en la memoria, recuperándolas, decodificándolas y ejecutándolas secuencialmente. También maneja la transferencia de datos entre la memoria y otros dispositivos de entrada/salida, así como el procesamiento de interrupciones y excepciones.

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/97885177/8195678c-1d1f-42ad-b9f6-9f15045d7a3c)


## Computer

 Unidad completa de hardware que se construye como parte del proyecto. Es el resultado final de la implementación de todos los componentes individuales, como la CPU, la memoria, los dispositivos de entrada/salida, etc. El archivo Computer.hdl es una parte esencial de este proceso, ya que define la estructura y el funcionamiento de la computadora completa.

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/97885177/a125c5c8-8497-4f48-a019-623ee6ed985b)


## Memory

Memoria de acceso aleatorio (RAM) que se construye desde cero utilizando puertas lógicas básicas. Este componente esencial permite el almacenamiento temporal de datos durante la ejecución de programas y se organiza en direcciones para acceder a ubicaciones específicas. Implementada a través del archivo Memory.hdl, esta memoria es fundamental para cargar y almacenar datos e instrucciones que la CPU necesita para ejecutar programas, facilitando así la construcción de una computadora completa desde el nivel más bajo de hardware en el proyecto Nand2tetris.
