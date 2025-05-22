Feature: Agregar producto al carrito
  Scenario: Agregar producto desde listado
    Given El usuario esta en una pagina de producto
    When Hace clic en "Add to cart"
    Then Debera ver una confirmacion del agregado
    Then El producto debera aparecer en el carrito
