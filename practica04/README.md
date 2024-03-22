se explicará el funcionamiento de tres clases que componen un ensamblador diseñado para traducir programas escritos en lenguaje ensamblador simbólico Hack a código binario ejecutable en la plataforma de hardware Hack.

## SymbolTable

La clase `SymbolTable` es responsable de mantener un mapa de símbolos y sus direcciones correspondientes.

- **Método `addEntry(symbol, address)`:** Este método agrega una entrada al mapa de símbolos, asociando un símbolo dado con una dirección dada.
  
- **Método `contains(symbol)`:** Este método verifica si un símbolo está presente en la tabla de símbolos.
  
- **Método `getAddress(symbol)`:** Este método devuelve la dirección asociada con un símbolo dado.

## Code

La clase `Code` es responsable de traducir instrucciones de lenguaje ensamblador Hack a código binario.

- **Constructor `Code(line)`:** Este constructor toma una línea de código en lenguaje ensamblador Hack y extrae las partes relevantes (destino, computación y salto) para su posterior traducción.
  
- **Métodos de traducción (`compFunction()`, `destFunction()`, `jumpFunction()`):** Estos métodos toman las partes extraídas de la instrucción y las traducen a sus equivalentes en código binario, de acuerdo con las convenciones del lenguaje ensamblador Hack.

## Parser

La clase `Parser` es responsable de analizar y dividir el código en líneas individuales para su procesamiento.

- **Constructor `Parser(name)`:** Este constructor inicializa el objeto `Parser` con un archivo de entrada y lee las líneas del archivo en una lista, eliminando los comentarios.
  
- **Método `hasMoreLines()`:** Este método verifica si quedan más líneas por procesar.
  
- **Método `advance()`:** Este método avanza al siguiente línea de código.
  
- **Método `instructionType()`:** Este método determina el tipo de instrucción de la línea actual (A_INSTRUCTION, L_INSTRUCTION o C_INSTRUCTION).
  
- **Métodos `symbol()`, `dest()` y `comp()`:** Estos métodos extraen y devuelven el símbolo, el destino y la parte de computación de una instrucción C, respectivamente.

## Conclusiones

El ensamblador implementado mediante estas clases permite la traducción efectiva de programas escritos en lenguaje ensamblador Hack a código binario ejecutable en la plataforma de hardware Hack. Cada clase cumple un papel específico en el proceso de ensamblaje, desde el manejo de símbolos hasta la traducción de instrucciones.

## Preguntas
###  1. Teniendo en cuenta las características del ensamblador, ¿Cuál es la principal limitante que observan? Justifique su respuesta.
Una de las principales limitaciones del lenguaje ensamblador es su complejidad y su dependencia directa del hardware subyacente. El ensamblador es un lenguaje de programación de bajo nivel, esto implica que las instrucciones escritas en ensamblador están más cerca del lenguaje de máquina que de los lenguajes de alto nivel, lo que puede hacer que la programación en ensamblador sea tediosa y propensa a errores.
## bonus
### ¿Por qué es tan importante el ensamblador?
El ensamblador es importante porque proporciona control directo sobre el hardware, es esencial para sistemas embebidos y de bajo nivel, permite programar dispositivos de hardware específicos, ayuda a comprender la arquitectura del computador y permite la optimización de rendimiento a un nivel extremadamente bajo.
