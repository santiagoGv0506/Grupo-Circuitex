# Practica 02
En esta practica se realizaron los proyectos 2 y 3 de nand2tetris con el proposito de en una primera insancia desarrollan los chips necesarios para poder hacer una unidad aritmetica logica (ALU) que pueda realizar las diferentes funciones para las cuales esta diseñada y por otro lado desarrollar una unidad de persistencia de informacion haciendo uso de una unidad bit con compuertas que permita luego hacer y guardar registros con los cuales poder desarrollar la RAM.

# Códigos

## HalfAdder
El halfAdder realiza la suma logica de dos inputs, al ejecutarlo el resultado de la salida suma da 0 si ambos inputs son diferentes y da uno si son iguales, lo cual es la definicion de la conmuerta xor, para el carry solamente da uno si ambos inputs son uno, esto recuerda a la compuerta and, por lo tanto para realizar el halfAdder se utilizan las compuertas xor y and con los inputs y sus outputs son el sum y carry respectivamente.
## FullAdder
El fullAdder realiza la suma de 3 inputs de un bit, para su realizacion utilizamos el HalfAdder realizado antes sumando los dos primeros inputs, luego utilizamos otro HalfAdder para sumar el tercer input y el output de la primera suma, para el carry simplemente utilizamos un or cuyos inputs sean los carry de los dos HalfAdder que empleamos.
## Add16
Para el Add16 hacemos basicamente un Adder para inputs de 16 bits, para realizarlo utilizamos en un pincipio un HalfAdder para el primer bit del input, seguidamente utilizamos 14 FullAdders para los bits restantes utilizando el carry del Adder anterior como valor de input C de forma que el primer FullAdder utiliza el carry del HalfAdder y el 2 FullAdder usa el carry del primero y asi consecuentemente hasta el ultimo FullAdder
## Inc16
Un incremento funciona de igual manera que el Add16 con la unica diferencia de que solo tenemos un input de 16 bits al cual le sumamos un 1, por lo tanto asignamos el input de 16 bits al valor a de un Add16 y para el segundo input utilizamos la condicion b[0]=true para sumarle ese uno al primer input y el resultado se lo asignamos a nuestro output.
## ALU

## Bit

## Register

## RAM8
La RAM de 8 registros funciona tal y como su nombre lo indica con solo 8 registers. Lo primero que realizamos fue utilizar un demultiplexor para cargar el load a la direccion del registro utilizando el ADRESS al que se desea acceder, una vez hecho esto, todas las salidas del demultiplexor se cargan a la entrada load de cada register, de esta manera solo se actualiza el registro seleccionado. Para leer utilizamos un multiplexor cuyas entradas son las salidas de cada registro de manera que segun el adress, solo se mostrara la salida seleccionada. Asi obtuvimos una Ram de 8 registros que nos permite almacenar informacion y es la base para realizar las RAM compuestas.

## RAM64

## RAM512

## RAM4k

## RAM16K

## PC

# Preguntas adicionales

## ¿Cuál es el objetivo de cada uno de esos proyectos con sus palabras y describa que debe hacer para desarrollarlo?
El principal objetivo de el proyecto dos es entender como funciona la logica que permite al procesador realizar opreaciones aritmeticas.En este caso la ALU permite realizar operaciones con dos entradas binarias. Para poder entender el funcionamiento de la ALU y en consencuencia el funcionamiento de la logica aritmetica de procesador es necesario realizar diversos chips logicos siguiendo un orden, del menos complejo al mas complejo, siguiendo el orden: HalfAdder, FullAdder, Add16, Inc16 y finalizando con el ALU. Es importante destacar que es necesario entender la naturaleza de las operaciones con binarios y como el computador interpreta estas.

Si bien el principal objetivo del proyecto dos era entender la logica aritmetica, el principal objetivo de proyecto tres es entender la logica secuencial y como se relaciona con la memoria. Para esto es necesario entender los tiempos de reloj y como el computador guarda la información, ademas de entender porque se necesita que un computador pueda realizar acciones una por una teniendo en cuenta el estado anterior. De la misma manera que en el proyecto dos, es necesario realizar una serie de chips logicos que van aumentando de complejidad y capacidad, por ejemplo, se sabe que con varias ram8 puede crearse una ram64 y con varias ram64 puede crearse una ram512, a su vez la ram8 contiene registros los cuales a su vez contienen bits.

## Explique las principales diferencias entre la lógica aritmética y la lógica secuencial.

1) La logica aritmetica se realiza en un instante y no requiere acceso a un estado anterior de la operacion mientras que la logica secuencial requiere tener acceso a el estado anterior de la operacion. Se podría decir que la logica aritmetica permite realizar operaciones instantaneamente mientras que la logica secuencial permite realizar operaciones paso a paso.
2) La logica aritmetica no depende de pulsos de reloj a diferencia de la logica secuencial cuya base son estos mismos.
3) La presencia de memoria, que no es necesaria en la logica aritmetica ya que es una operacion logica cuyo fin es dar un resultado. En la logica secuencial el concepto de memoria es clave para poder llevar a cabo las operaciones.
