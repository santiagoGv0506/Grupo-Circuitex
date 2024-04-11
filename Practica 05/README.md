# Proyectos 7 y 8: La Máquina Virtual

# proyecto 8
En este proyecto se retoma el traductor basico VM que se construyo en el proyecto 7 a un traductor VM a gran escala.

## VMTranslator
La clase `VMTranslator` se encarga de dividir el proceso de traduccion usando el `codewriter` y `parser` dependiendo del formato en el que se ingresen los archivos.

## CodeWriter
La clase `CodeWriter` se encarga de realizar el codigo ensamblador o assembly que realiza el comando de analizis o parsed command.

## Parser
La clase `parser` se encarga de hacer el analisis del archivo .MV, para ello lee el archivo omitiendo los espacios blancos y comentarios, convierte los comandos de analisis en componentes lexicos y proporciona un acceso conveniente a estos componentes.


