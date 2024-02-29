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
para poder tener una unidad de persistencia de memoria de un bit tenemos que poder guardar y cargar informacion, para esto tenemos dos inputs in y load, este ultimo nos sirve como condicion para saber si debemos guardar nueva informacion o mantener la informacion anterior de forma que si el load es 1 ingresamos nueva informacion, de lo contrario mantenemos la informacion, para realizar esto utilizamos un multiplexor asignando el load al valor del selector para que el decida que informacion pasa, para las entradas hacemos un loop usando un data flip flop DFF cuya entrada es la salida del Mux y su salida vuelve al segundo input del Mux, de esta forma si el load carga un in = 1 el flip flop cargá la nueva entrada en cambio si el load no es 1 el flip flp cargará la informacion que tenia antes.
## Register
El register es un conjunto de x bits, en este caso es un registro de 16 bits, para su realizacion utilizamos el chip de bit que realizamos anterior mente, asignando un bit para cada uno de los 16 valores del input, pero le asignamos a todos los 16 bits el mismo valor del load, con el cual el registro sabra si debe almacenar la informacion en caso de que el load sea uno o no almacenar la informacion del input en caso que el load sea diferente a uno.

## RAM8
La RAM de 8 registros funciona tal y como su nombre lo indica con solo 8 registers. Lo primero que realizamos fue utilizar un demultiplexor para cargar el load a la direccion del registro utilizando el ADRESS al que se desea acceder, una vez hecho esto, todas las salidas del demultiplexor se cargan a la entrada load de cada register, de esta manera solo se actualiza el registro seleccionado. Para leer utilizamos un multiplexor cuyas entradas son las salidas de cada registro de manera que segun el adress, solo se mostrara la salida seleccionada. Asi obtuvimos una Ram de 8 registros que nos permite almacenar informacion y es la base para realizar las RAM compuestas.

## RAM64
Para realizar la RAM de 64 necesitamos 8 RAMs de 8 registros, por lo que la logica funciona de la misma manera, llegando a ser algo recursivo, y probablemente la causa de la demora en muchos de estos chips y posteriores. Al igual que con la RAM de 8 lo primero es un demultiplexor que en este caso no selecciona el registro sino la RAM 1,2,3...8, para esto nuestro adress ahora es de 6 bits y utilizamos los 3 mas significativos para seleccionar la RAM y los 3 menos significativos para seleccionar el registro dentro de esta RAM. Este demultiplexor asigna el load a la RAM8 correspondiente segun el adress[3..5] (bits mas significativos) y cada una de las RAM8 envia la salida del demultiplexor correspondiente. Pero dentro de las RAM8 enviamos como adress sus bits menos significativos adress[0..2]. Finalmente para leer usamos otra vez un multiplexor cuyas entradas con las salidas de cada RAM8 y solo permitira la salida de aquella que corresponda a la salida del adress[3..5].

## RAM512
Como se menciono en los apartados anteriores, el principal problema de utilizar tanta recursividad es que cada segundo se vuelve mas lento el programa en ejecucuion, ya que en este caso, una RAM512 invoca 8 RAM64, cada una de estas 8 RAM8 y cada una de estas 8 register sin mencionar sus bits. Al igual que las anteriores bits se utiliza un demultiplexor para escribir y selecciona la RAM64 con los 3 bits mas signifcativos adress[6..8] y llama las RAM64 enviandoles como adress[0..5]. Para leer se utiliza un multiplexor que recibe las salidas de las RAM64 y selecciona la salida con adress[6..8]. Podemos concluir a esta altura que los 3 bits mas significativos del adress se utilizan en los DMUX Y MUX, mientras que el resto de bits se envian a la funcion RAM interna.

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
