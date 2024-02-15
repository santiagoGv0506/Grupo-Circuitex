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


![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/97885177/4943beca-ab3d-4276-8582-bfeed96ed304)


## Or16
La compuerta Or16 recibe como entrada un input de 16 bits, para su elaboracion entonces se asignan los valores de entrada y salida como arrays de 16 de longitud y se utilizan 16 compuertas or para comparar bit por bit los valores del input iniciando en el indicie 0 hasta el 15.

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/129707742/f1b67be2-cb71-4326-9874-179aa2b39486)

## Or8Way
La Or8Way es una compuerta que recibe 8 entradas de 1 bit, para su elaboracion se utilizan en principio 4 compuertas Or con las cuales se comparan las 8 entradas iniciales, despues asignamos las 4 salidas a 2 nuevas compuertas Or cuyas salidas finalmente se le asignan a una ultima compuerta Or que nos da la salida final.

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/129707742/946a2d05-5263-4312-a6da-de6187a8382d)


## Xor
El circuito logico Xor solo retorna un 1 logico solo cuando una de las dos entradas está en 1. Se puede hacer con dos compuertas And, dos compuertas Not y una compuerta Or.

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/92127039/98456197-6124-43c5-9356-8c5cf41dd226)


## Mux
El multiplexor toma una de las dos entradas y las convierte en salida dependiendo del valor logico de un selector. Se construye con tres entradas, el selector y otras dos entradas, a su vez tiene una salida. Un multiplexor 2 a 1 puede construirse con dos And, una Not y una Or.

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/92127039/37d6be2c-fd40-436b-9fcf-5780d7a163f2)

## Mux16

La compuerta Mux16 es igual que una compuerta Mux convencional con la diferencia de que su entrada son un numero binario de 16 bits, pára su elaboracion se declara las entradas (a,b) y la salida variables tipo array con una longitud de 16, luego se utilizan 16 compuertas Mux y les asignamos una a una de forma secuencial cada bit del array, la entrada de seleccion y la salida, de forma que la primera compuerta Mux realiza la multiplexacion para los bits a[0] y b[0], asignando a la salida el valor out[0], se continua asi con las siguientes compuertas Mux hasta llegar al ultimo indice, la entrada de seleccion permanece igual para todos los Mux.

![mux16](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/129707742/b81853f8-34ae-4bd7-bff2-3c313c022250) 


## Mux4way16

Para el multiplexor de 16 bits y 4 entradas reutilizamos el codigo de Mux16, primero filtramos las salidas a y b con el bit sel[0], y con este mismo filtramos las salidas c y d.
Estas salidas auxiliares las llamamos out1 y out2, y son filtradas nuevamente con la funcion logica Mux16 utilizando como el bit sel[1], finalmente esta salida es la mostrada en pantalla.

![image](https://tomorrow0w0.gitbooks.io/nand2tetris-homework/content/assets/Mux4Way16.png)

## Mux8way16

Para el multiplexor de 8 entradas y 16 bits, tambien reutilizamos el codigo de Mux16, para el cual filtramos las entradas a y b; c y d; e y f; g y h con el bit de menor ssignificancia del select sel[0], posteriormente estas 4 salidas auxiliares out1 y out2; out3 y out4 se filtran segun el segundo bit del select sel[1] y finalmente las dos salidas auxiliares obtenidas del anterior paso se filtran con el ultimo bit del select sel[2], obteniendo el out correspondiente a la entrada adecuada segun el select.

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/159449277/a70ab5b2-6621-4626-bf9a-75f9e5d943e9)

## Dmux4way

Para el demultiplexor de 4 salidas, se utilizo logica de 1 para el cual si por ejemplo queremos que nuestra salida sea la a y le corresponde el 00, conectamos la entrada in con sel[0] negado y sel[1] negado mediante compuertas and, pero si queremos que la salida sea c, le corresponde el 10 en el select, conectamos la entrada in con sel[0] negado y sel[1].

![image](https://github.com/santiagoGv0506/Grupo-Circuitex/assets/159449277/bdb2382d-2154-4ff9-b927-f6486f2ce03b)

## Créditos

Este proyecto se basa en el trabajo de Noam Nisan y Shimon Schocken "The Elements of Computing Systems" y en el curso Arquitectura de redes. 
Agradecemos su contribución a la educación en el campo de la informática.

Compuertas logicas: https://hetpro-store.com/TUTORIALES/compuertas-logicas/

The Elements of Computing Systems: https://www.nand2tetris.org/_files/ugd/44046b_f2c9e41f0b204a34ab78be0ae4953128.pdf

From Nand to Tetris Building a Modern Computer from First Principles: https://drive.google.com/file/d/1MY1buFHo_Wx5DPrKhCNSA2cm5ltwFJzM/view?pli=1


VLSI Universe, MULTIPLEXOR:
https://vlsiuniverse.blogspot.com/2016/07/multiplexer.html
