# language : es

Característica: Añadir nuevas elecciones
  Escenario: Agregar unas nuevas elecciones a la lista de elecciones activas
    Dado una lista con las elecciones activas
    Cuando creamos unas elecciones con un nombre "Eleccion cucumber",un numero de opciones de 3 y una fecha de inicio de "24/06/2016" 
    Entonces comprobamos que para la fecha "24/06/2016" existe una eleccion almacenada