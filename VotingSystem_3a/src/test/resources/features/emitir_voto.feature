# language : es

Característica: Emitir voto
  Escenario: Un votante emite su voto de forma electrónica
    Dado una lista con las elecciones que se encuentran activas
    Cuando el usuario selecciona la elección "Eleccion 1"
    Entonces se le muestran las opciones de voto para esas elección
    Cuando el usuario selecciona la opción "Candidatura 2" y selecciona guardar
    Entonces se almacena el voto y se registra que votó