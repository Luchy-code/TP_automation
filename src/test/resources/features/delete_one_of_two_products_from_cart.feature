Feature: Agregar 2 productos al carrito y borrar el ultimo producto

  Scenario: Agregar dos productos al carrito y borrar el ultimo
    Given El usuario accede a la pagina principal para agregar
    When Agrega dos productos al carrito
    And Accede al carrito y elimina el ultimo producto
    Then Deberia haber un unico producto en el carrito


