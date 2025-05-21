Feature: Registro de nuevo usuario
  Scenario: Registro exitoso con datos válidos
    Given El usuario accede a la página de registro
    When Ingresa los datos requeridos
    And Hace clic en "Create Account"
    Then Debería ver el mensaje "Logged in as"
