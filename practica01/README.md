# Proyecto 1: Lógica Booleana (Implementación de Compuertas Lógicas Básicas).

##
Este proyecto forma parte del curso de Arquitectura de Computadores y tiene como objetivo principal proporcionar una comprensión práctica de los principios de la lógica booleana y la implementación de compuertas lógicas básicas utilizando el lenguaje de descripción de hardware HDL.

# Instrucciones.

Primeramente se descarga la herramienta creada por los autores Noam Nisan y Shimon Schocken de Nand2tetris en el sigueinte link https://www.nand2tetris.org/project01 como complemento adicional para el correcto funcionamemiento de la herramienta,  se debe descargar Java, descargar la carpeta.zip y abrir el HardwareSimulator en la carpeta de "tools" y proceder a editar los archivos .hdl para despues ejecutarlos en sistema anteriormente nombrado.

# Archivos y pruebas.

## Nand
Es la compuerta nativa que nos proporciona el sistema, se derivan de esta todas las demás compuertas.

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/159449792/6b3d9598-49f6-49b6-952b-80c3e13781eb)

# Not
Para esta compuerta se utilizo la compuerta nativa Nand, usando la misma variable en las dos entradas y teniendo como salida la negacion de las mismas.

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

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/97885177/5041d6ca-f27a-4648-9de4-44a4d36adfc6)


## And16
El circuito lógico And16 aplica la tabla de verdad del and a cada uno de los bits dentro de los espacios de de 16 bits, es decir que viendolo como si este fuera un arreglo, va recorriendolo aplicandole la compuerta and a cada bit.

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/97885177/66e99371-e564-4edd-b64e-51065ebda849)

## Xor
El circuito logico Xor solo retorna un 1 logico solo cuando una de las dos entradas está en 1. Se puede hacer con dos compuertas And, dos compuertas Not y una compuerta Or.

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/92127039/98456197-6124-43c5-9356-8c5cf41dd226)


## Mux
El multiplexor toma una de las dos entradas y las convierte en salida dependiendo del valor logico de un selector. Se construye con tres entradas, el selector y otras dos entradas, a su vez tiene una salida. Un multiplexor 2 a 1 puede construirse con dos And, una Not y una Or.

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/92127039/37d6be2c-fd40-436b-9fcf-5780d7a163f2)

## Mux4way16

![image](https://tomorrow0w0.gitbooks.io/nand2tetris-homework/content/assets/Mux4Way16.png)

Para el multiplexor de 16 bits y 4 entradas reutilizamos el codigo de Mux16, primero filtramos las salidas a y b con el bit sel[0], y con este mismo filtramos las salidas c y d.
Estas salidas auxiliares las llamamos out1 y out2, y son filtradas nuevamente con la funcion logica Mux16 utilizando como el bit sel[1], finalmente esta salida es la mostrada en pantalla.

## Mux8way16

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/159449277/a70ab5b2-6621-4626-bf9a-75f9e5d943e9)



## Créditos

Este proyecto se basa en el trabajo de Noam Nisan y Shimon Schocken "The Elements of Computing Systems" y en el curso Arquitectura de redes. 
Agradecemos su contribución a la educación en el campo de la informática.

Compuertas logicas: https://hetpro-store.com/TUTORIALES/compuertas-logicas/

The Elements of Computing Systems: https://www.nand2tetris.org/_files/ugd/44046b_f2c9e41f0b204a34ab78be0ae4953128.pdf

From Nand to Tetris Building a Modern Computer from First Principles: https://drive.google.com/file/d/1MY1buFHo_Wx5DPrKhCNSA2cm5ltwFJzM/view?pli=1
