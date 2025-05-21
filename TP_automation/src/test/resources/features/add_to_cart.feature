Feature: Agregar producto al carrito
  Scenario: Agregar producto desde listado
    Given El usuario está en una página de producto
    When Hace clic en "Add to cart"
    Then Debería ver una confirmación del agregado
    Then El producto debería aparecer en el carrito
