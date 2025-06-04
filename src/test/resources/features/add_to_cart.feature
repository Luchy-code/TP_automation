Feature: Agregar productos al carrito

  Scenario: Agregar producto desde la pagina principal usando hover
    Given El usuario accede a la pagina principal
    When Agrega el primer producto al carrito con hover
    Then Deberia ver el mensaje de confirmacion "Added"

  Scenario: Agregar producto desde la pagina de detalles
    Given El usuario accede a la pagina principal
    When Ingresa a la pagina de detalles del primer producto y lo agrega al carrito
    Then Deberia ver el mensaje de confirmacion "Added"
