Feature: Validar Home
  Scenario: El usuario accede a la página principal
    Given el usuario navega a la página de inicio
    Then el título de la página debe ser "Automation Exercise"
