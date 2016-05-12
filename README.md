Voting System
=============
[![Voting System](https://raw.githubusercontent.com/Arquisoft/Voting_3a/master/VotingSystem/src/main/resources/static/images/logo.gif)](https://github.com/Arquisoft/Voting_3a/)


[![Join the chat at https://gitter.im/Arquisoft/Voting_3a](https://badges.gitter.im/Arquisoft/Voting_3a.svg)](https://gitter.im/Arquisoft/Voting_3a?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

[![Build Status](https://travis-ci.org/Arquisoft/Voting_3a.svg)](https://travis-ci.org/Arquisoft/Voting_3a)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/b7c23b065b37409ebc7bf07d9399df36)](https://www.codacy.com/app/jelabra/Voting_3a)

Voting System
[![Dependency Status](https://www.versioneye.com/user/projects/572a47c5a0ca35004baf83eb/badge.svg?style=flat)](https://www.versioneye.com/user/projects/572a47c5a0ca35004baf83eb)

Censuses SubSystem
[![Dependency Status](https://www.versioneye.com/user/projects/572a47c0a0ca350034be6e7a/badge.svg?style=flat)](https://www.versioneye.com/user/projects/572a47c0a0ca350034be6e7a)

[![codecov.io](https://codecov.io/github/Arquisoft/Voting_3a/coverage.svg?branch=master)](https://codecov.io/github/Arquisoft/Voting_3a?branch=master)

![codecov.io](https://codecov.io/gh/Arquisoft/Voting_3a/branch.svg?branch=master)

Subsistema de VoteCounting desplegado en heroku como prototipo de presentacion final del sistema. El sistema definitivo sera desplegado antes del cierre definitivo del plazo entrega:

[![ViewOnHeroku](https://img.shields.io/badge/View%20on-Heroku-ff69b4.svg)](https://votecounting3av2.herokuapp.com)


## Censuses3A

Censuses es un subsistema que permite cargar los datos de un determinado censo electoral contenidos en ficheros con extension XSLX o TXT. Además también permite generar las cartas que serán enviadas a los electores

### Forma de ejecución
Para la ejecución del programa se deben proporcionar tres parámetros:
* -x | -t -> Formato del fichero de entrada (Excel o TXT)
* nombrefichero -> Ruta y nombre del fichero de entrada
* word txt -> Formato de salida de las cartas
Un ejemplo sería:
```
-x src/test/resources/test.xlsx word
```

## Voters

Los usuarios podrán acceder al sistema para comprobar que han sido dados de alta, a partir de la información de la carta recibida. Para ello disponen de un servicio Web sencillo que toma como parámetros codificados en una llamada POST el nombre de usuario y la clave, y devuelva información sobre el código de colegio electoral del votante en caso correcto o informa del error en case incorrecto. Tanto los parámetros como la respuesta se envían en formato JSON.

Dispone de un sencillo interfaz html para facilitar la interaccion con el usuario.

### Pasos para lanzar el sistema


* Descargar el codigo del repositorio mediante la instruccion de git ```git clone https://github.com/Arquisoft/voters_3a```
* Lanzar la aplicacion mediante la instruccion de maven ```mvn spring-boot:run```
* Ahora tendremos la aplicacion corriendo en local y tan solo tendremos que poner en el navegador ```localhost:8080```


## Vote Counting

Realiza un recuento de los votos y publica los resultados para que sean accesibles de forma pública.

## Voting System

Voting System es un sistema de gestión de votaciones de manera on-line. Permitirá tanto la configuración de los parámetros de gestión de las votaciones como también la funcionalidad de permitir a los votantes emitir su voto de manera electrónica durante el periodo que se estime oportuno.

### Lanzamiento de la aplicación
La aplicación puede ser lanzada ejecutando mediante línea de comandos la instrucción ```spring-boot:run``` y se accede mediante el navegador en la URI ```http://localhost:8281```

También puedes ver el subsistema VoteCounting desplegada en Heroku presionando el botón inferior

[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://votingsystem3a.herokuapp.com)

### Bases de datos de la aplicación
Para el tratamiento de los datos se han empleado tres bases de datos diferentes:
* ```HSQLDB``` Para los datos en producción (en local). Se encuentra disponible en el siguiente [enlace](https://www.dropbox.com/sh/g3y9b00ascxo7js/AACNzXSTuYbxXI3vyRGSJFE5a?dl=0)
* ```HSQLDB``` Para pruebas en local. Se encuentra disponible en el siguiente [enlace](https://www.dropbox.com/sh/tyk6nnxkzb1kamd/AACQoa-V5mFDNLrnGiaa8MVva?dl=0)
* ```MySQL``` Para pruebas en remoto.


# Authors

* Amir Housein Tofigh Halati
* Carlos Lopez de Juan
* David González García
* Raúl Barba Tamargo
* Darío Rodríguez García
* Héctor Álvarez Ibáñez
* Jorge Vila Suárez
