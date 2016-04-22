# language: es
 Característica: Administrar recuento
   Escenario: Iniciar recuento
     Cuando el cliente entra en la web
     Entonces va a la ventana de administrador
     Entonces se valida con codigo de autentificacion "11" para la eleccion 1
     Y hace click en el boton de iniciar
     Entonces se le muestra el mensaje "Recuento iniciado"
   Escenario: Terminar recuento
   	 Cuando el cliente entra en la web
     Entonces va a la ventana de administrador
     Entonces se valida con codigo de autentificacion "11" para la eleccion 1
     Y hace click en el boton de terminar
     Entonces se le muestra el mensaje "Recuento terminado"
     