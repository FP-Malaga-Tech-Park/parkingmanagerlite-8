# language: es
Característica: Gestion de sorteos
  

  Escenario: Mostrar todos los sorteos
    Dado un usuario esta en la pagina inicial
    Cuando el usuario hace click sobre el botón de Sorteos
    Entonces se muestran todos los sorteos del sistema


  Escenario: Mostrar el formulario de creacion de sorteos
    Dado un usuario esta en la pagina de sorteos
    Cuando el usuario hace click sobre el botón de crear sorteo
    Entonces se muestra un formulario 
    Y se muestra el campo descripcion
    Y se muestra el boton crear

Escenario: Mostrar el contenido de la pagina sorteos
    Dado un usuario esta en la pagina sorteos
    Entonces se muestra el titulo
    Y se muestra el boton de crear sorteo
    Y se muestra la tabla

Escenario: Mostrar la pagina de creacion de sorteo
    Dado un usuario esta en la pagina sorteo
    Cuando el usuario hace click sobre el botón crear sorteo
    Entonces se muestra la pagina de creacion sorteo

Escenario: Mostrar la pagina de usuarios
    Dado un usuario esta en la pagina sorteos
    Cuando el usuario hace click sobre el boton usuarios
    Entonces se muestra la pagina usuarios

