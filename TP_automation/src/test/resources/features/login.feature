Feature: Login

  Scenario: Login exitoso
    Given El usuario accede a la página de login
    When Ingresa su email y contraseña válidos
    And Hace clic en el botón de login
    Then Debería ver el mensaje "Logged in as"
