# language: es
Característica: Gestion de usuarios

  Escenario: Mostrar todos los usuarios
    Dado un usuario esta en la pagina inicial
    Cuando el usuario hace click sobre el botón de Usuarios
    Entonces se muestran todos los usuarios del sistema

  Escenario: Mostrar el formulario de creacion de usuarios
    Dado un usuario esta en la pagina de usuarios
    Cuando el usuario hace click sobre el botón de crear usuario
    Entonces se muestra un formulario 
    Y se muestra el campo nombre
    Y se muestra el campo apellido
    Y se muestra el campo apellido2
    Y se muestra el campo correo
    Y se muestra la seleccion de rol

Escenario: Mostrar el contenido de la pagina users
    Dado un usuario esta en la pagina users
    Entonces se muestra el titulo 
    Y se muestra el boton de crear usuario
    Y se muestra la tabla

  Escenario: Mostrar la pagina de creacion de usuario
    Dado un usuario esta en la pagina user
    Cuando el usuario hace click sobre el botón de crear nuevo usuario
    Entonces se muestra la pagina de creacion de usuario

Escenario: Mostrar la pagina de sorteos
    Dado un usuario esta en la pagina user
    Cuando el usuario hace click sobre el boton sorteos
    Entonces se muestra la pagina de sorteos



