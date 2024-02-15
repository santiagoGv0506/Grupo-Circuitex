# Proyecto 1: Lógica Booleana (Implementación de Compuertas Lógicas Básicas).

## Este proyecto forma parte del curso de Arquitectura de Computadores y tiene como objetivo principal proporcionar una comprensión práctica de los principios de la lógica booleana y la implementación de compuertas lógicas básicas utilizando el lenguaje de descripción de hardware HDL.

# Instrucciones.

Primeramente se descarga la herramienta creada por los autores Noam Nisan y Shimon Schocken de Nand2tetris en el sigueinte link https://www.nand2tetris.org/project01 como complemento adicional para el correcto funcionamemiento de la herramienta,  se debe descargar Java, descargar la carpeta.zip y abrir el HardwareSimulator en la carpeta de "tools" y proceder a editar los archivos .hdl para despues ejecutarlos en sistema anteriormente nombrado.

# Estructura (archivos y pruebas).

## Nand
Es la compuerta nativa que nos proporciona el sistema, se derivan de esta todas las demás compuertas.

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/159449792/6b3d9598-49f6-49b6-952b-80c3e13781eb)

# Not
Para esta compuerta se utilizo la compuerta nativa Nand, usando la misma variable en las dos entradas y teniendo como salida la negacion de las mmismas.

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/159449792/63e50c97-b687-4125-8000-9d89f3aac5f2)

## And
Para esta compuerta se utiliza la compuerta nativa con dos entradas obteniendo una salida negada, y se vuelve a usar la misma compuerta haciendo una doble negación, teniendo la compuerta And.

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/159449792/143b336e-3152-4826-9f1d-6e86a2312e4b)

## Or 
Negamos cada una de las dos entradas con la compuerta Not, y esas salidas se niegan con una Nand.

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/159449792/225c0bc2-8892-48cf-8271-8f7ed13c950a)


## DMux 

La DMux  demultiplexor a comparación de la Mux esta tiene una entrada y el selector decide que salida le da entre dos posibles, el mejor ejemplo es alguien se para en un camino que se separa en dos, básicamente la persona elije por cual camino ir dependiendo de lo que el selector decida.


![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/97885177/c8976f81-f4b1-44d8-be27-f20f5a05e793)

## Not16
El circuito lógico Not16 lo que hace es en si lo mismo que el Not solo que a mayor escala, lo que hace es coger un cajón con 16 espacios y aplicar el inverso a  todos los indices la información que estos poseen. En otras palabras, una puerta Not de n bits aplica la operación booleana Not a cada uno delos bits en su bus de entrada de n bits.

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/97885177/a9feafd5-27c5-455a-aba2-6ed336cb6edd)

## Créditos

Este proyecto se basa en el trabajo de Noam Nisan y Shimon Schocken "The Elements of Computing Systems" y en el curso Arquitectura de redes. 
Agradecemos su contribución a la educación en el campo de la informática.

Compuertas logicas: https://hetpro-store.com/TUTORIALES/compuertas-logicas/

