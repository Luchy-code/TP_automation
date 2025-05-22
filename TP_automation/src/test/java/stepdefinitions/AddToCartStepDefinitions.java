package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

import pages.ProductPage;
import pages.CartPage;
import pages.HomePage;

import utils.BaseTest;

public class AddToCartStepDefinitions extends BaseTest {

    WebDriver driver;
    ProductPage productPage;
    CartPage cartPage;

    @Given("El usuario esta en una pagina de producto")
    public void El_usuario_esta_en_una_pagina_de_producto() {
    	iniciarDriver(); // Asegura que el driver esté iniciado
        productPage = new ProductPage(getDriver());
    }

    @When("Hace clic en el botón {string} en la página de producto")
    public void Hace_clic_en_el_boton_en_la_pagina_de_producto(String boton) {
        if (boton.equalsIgnoreCase("Add to cart")) {
            productPage.clickAddToCart();
        }
    }

    @Then("Debera ver una confirmacion del agregado")
    public void Debera_ver_una_confirmacion_del_agregado() {
        String confirm = productPage.getConfirmationText();
        assertTrue(confirm.contains("Added"), "El mensaje no contiene 'Added'");
        productPage.clickViewCart();
    }

    @Then("El producto debera aparecer en el carrito")
    public void El_producto_debera_aparecer_en_el_carrito() {
        cartPage = new CartPage(driver);
        String producto = cartPage.getProductName();
        assertNotNull(producto, "El producto no esta en el carrito");
        assertFalse(producto.isEmpty(), "El nombre del producto esta vacio");
        driver.quit();
    }
}
