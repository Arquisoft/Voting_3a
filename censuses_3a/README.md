# Censuses3A

[![Build Status](https://travis-ci.org/Arquisoft/censuses_3a.svg?branch=master)](https://travis-ci.org/Arquisoft/censuses_3a)  [![Coverage Status](https://coveralls.io/repos/github/Arquisoft/censuses_3a/badge.svg?branch=master)](https://coveralls.io/github/Arquisoft/censuses_3a?branch=master)
=========
Miembros del grupo:
* Darío Rodríguez García
* Jorge Vila Suárez
* Héctor Álvarez Ibáñez

### Descripción del proyecto
Censuses es un subsistema que permite cargar los datos de un determinado censo electoral contenidos en ficheros con extension XSLX o TXT. Además también permite generar las cartas que serán enviadas a los electores

#### Forma de ejecución
Para la ejecución del programa se deben proporcionar tres parámetros:
* -x | -t -> Formato del fichero de entrada (Excel o TXT)
* nombrefichero -> Ruta y nombre del fichero de entrada
* word txt -> Formato de salida de las cartas
Un ejemplo sería:
```
-x src/test/resources/test.xlsx word
```

