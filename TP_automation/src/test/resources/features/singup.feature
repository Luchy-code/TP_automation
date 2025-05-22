Feature: Registro de nuevo usuario

  Scenario: Registro exitoso con datos validos
    Given El usuario accede a la pagina de registro
    When Ingresa los datos requeridos
    And Hace clic en "Create Account"
    Then El nuevo usuario deberia ver el mensaje de confirmacion "ACCOUNT CREATED!"
