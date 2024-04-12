# Proyectos 7 y 8: La Máquina Virtual

# Proyecto 7
Para realizar este proyecto se utilizo el lenguaje de programación Python, y se encuentra adjunto en la carpeta `proyecto 7` los .py generados, además de las carpetas SimpleAdd y StackTest que contienen los archivos .asm, .tst, .hack y .tst utilizados y obtenidos al utilizar los codigos desarrollados. Estos codigos adjuntos son el `VMParser.py`, `VMCodeWriter.py` y el `VMTranslator.py`:

## Parser

La clase Parser tiene como atributos las constantes de tipo instruccion con un numero predeterminado asignado, en su constructor recibe un archivo o nombre del archivo, lo abre y separa por saltos de linea guardando las lineas en una pila llamada _lines, luego se implementa el método advance() que permite cambiar la linea actual mediante el comando pop(), el método extra_commands equiale a un hasMoreLines y su función es averiguar si hay lineas en la pila. Los métodos _is_arithmetic, _is_push, _is_pop devuelven falso o verdadero según los tipos de operacion que hay en la linea actual. El método command_Type utiliza los anteriores métodos para identificar si el tipo de instruccion de la linea actual es Aritmetica, Push o Pop. Los métodos command, segment e index, devuelven el valor del comando, segmento e indice de la linea actual respectivamente.

## CodeWriter
La clase CodeWriter tiene un constructor qur genera un archivo de salida a partir del nombre del archivo cambiando su tipo por .asm y además inicializa ciertos valores. Cada uno de los métodos de esta clase traduce la instruccion .vm correspondiente a lenguaje de ensamblador, de tal manera, que siguen reglas predefinidas en el proyecto anterior para establecer los accesos a memoria ademas de los métodos write, que se encargan de escribir en el archivo de texto plano la traduccion a cada instruccion de tipo .vm.

## Translator
En la clase VMTranslator, poseemos un constructor que genera una instancia de la clase Parser y otra de la clase CodeWriter. Además existe el método translate, el cual usa el metodo de extra_commands() de la clase Parser dentro de un while para saber si hay instrucciones para traducir, y con ayuda de la función command_type separa los tipos de instrucciones recibidas y llama la respectiva funcion de escribir en la clase CodeWriter segun el tipo de instruccion hasta terminar.



# Proyecto 8
En este proyecto se retoma el traductor basico VM que se construyo en el proyecto 7 a un traductor VM a gran escala.

## Parser
La clase `parser` se encarga de hacer el analisis del archivo .MV, para ello tiene un constructor que abre el archivo para preparar el parsing, despues tiene el metodo `HasMoreCommands()` que indica si hay mas lineas o comandos en el input, si el valor de esté ultimo es igual a true se llama al metodo `advance()` el cual ejecuta el siguiente comando y lo establece como comando actual, el metodo `CommandType` utiliza los mismos comandos que en el proyecto 7 para representar el tipo de comando actual que se esta utilizando pero ademas se le añaden los comandos goto, if-goto, label, call, function y return, el metodo `arg1` devuelve el primer argumento del comando actual a exepcion de si el comando es return, en este caso la funcion no sera llamada, finalmente el metodo `arg2` devolvera el 2 argumento del comando que se este ejecutando actualmente, pero solo se llamara si el comando actual es push, pop, function o call.

## CodeWriter
La clase `CodeWriter` se encarga de realizar el codigo ensamblador o assembly que realiza el comando de analizis o parsed command, esté consta de un constructor que genera un archivo de salida listo para escribir las instrucciones assembly en el, tiene un metodo `setFileName` que inicializa la traduccion de un nuevo archivo VM, posee los metodos `writeAritmetic` y `writePushPop` elaborados en el proyecto 7 para los comandos aritmeticos y de push y pop implementados, a estos metodos se le adicionan los metodos respectivos para los nuevos comandos implementados en el parser `writeLabel`, `writeGoto`, `writeIf`, `writeFunction`, `writeCall` y `writeReturn` que generan el respectivo codigo assembly para efectuar el comando, finalmente tenemos el metodo tambien implementado en el proyecto 7 `close` que cierra el archivo de output.

## VMTranslator
La clase `VMTranslator` se encarga de dividir el proceso de traduccion, construye primeramente un `codewriter` Si el input es un archivo .vm construye un `Parser` para manejar el archivo de entrada. Para cada comando VM en el archivo de entrada utiliza el Parser para analizar el comando y utiliza el CodeWriter para generar código ensamblador a partir de él, por otro lado, si el input es una carpeta de archivos VM utiliza los nuevos comandos de funcion y ramificacion del parser para generar el respectivo codigo de ensamblador con el codewriter.

# Teniendo en cuenta el marco de estas dos prácticas que son las máquinas virtuales. ¿Cuál cree que es el futuro de las máquinas virtuales?
Las maquinas virtuales son representaciones virtuales o emuladores de computadores que permiten simular procesos de una computadora mediante un lenguaje propio que podemos llevar al lenguaje de ensamblador y posteriormente a hack. Según algunas fuentes, las maquinas virtuales no estan condenadas a desaparecer pero, su crecimiento se reducira en comparacion al crecimiento de los contenedores.

# Fuentes
https://www.ibm.com/mx-es/topics/virtual-machines 
https://es.linkedin.com/learning/fundamentos-de-la-carrera-de-administracion-de-sistemas-de-microsoft-y-linkedin/el-futuro-de-las-maquinas-virtuales-y-los-contenedores#:~:text=Las%20m%C3%A1quinas%20virtuales%20no%20desaparecer%C3%A1n,del%20hogar%20y%20la%20oficina.


