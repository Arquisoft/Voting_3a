Voters
======

Voters Subsystem

[![Build Status](https://travis-ci.org/Arquisoft/voters_3a.svg?branch=master)](https://travis-ci.org/Arquisoft/voters_3a)
[![codecov.io](https://codecov.io/github/Arquisoft/voters_3a/coverage.svg?branch=master)](https://codecov.io/github/Arquisoft/voters_3a?branch=master)

Los usuarios podran acceder al sistema para comprobar que han sido dados de alta, a partir de la información de la carta recibida. Para ello disponen de un servicio Web sencillo que toma como parámetros codificados en una llamada POST el nombre de usuario y la clave, y devuelva información sobre el código de colegio electoral del votante en caso correcto o informa del error en case incorrecto. Tanto los parámetros como la respuesta se envian en formato JSON.

Dispone de un sencillo interfaz html para facilitar la interaccion con el usuario.

Pasos para lanzar el sistema
=======

* Descargar el codigo del repositorio mediante la instruccion de git ```git clone https://github.com/Arquisoft/voters_3a```
* Lanzar la aplicacion mediante la instruccion de maven ```mvn spring-boot:run```
* Ahora tendremos la aplicacion corriendo en local y tan solo tendremos que poner en el navegador ```localhost:8080```

Authors
=======
* Amir Housein Tofigh Halati
* Carlos Lopez de Juan
* David González García
* Raul Barba Tamargo
