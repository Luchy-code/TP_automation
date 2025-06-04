Feature: Login

  Scenario: Login exitoso
    Given El usuario accede a la pagina de login
    When Ingresa su email y contrasena validos
    And Hace clic en el boton de login
    Then El usuario deberia ver su nombre de usuario en el menu de usuario "Logged in as"
