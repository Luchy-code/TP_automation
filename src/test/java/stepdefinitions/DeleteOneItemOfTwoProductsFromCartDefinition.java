package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.ProductPage;
import pages.CartPage;
import utils.BaseTest;

import java.util.List;

public class DeleteOneItemOfTwoProductsFromCartDefinition extends BaseTest {
    WebDriver driver;
    ProductPage productPage;
    CartPage cartPage;

    @Given("El usuario accede a la pagina principal para agregar")
    public void El_usuario_accede_a_la_pagina_principal() {
        iniciarDriver();
        driver = getDriver();
        driver.get("https://automationexercise.com");
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }


    @When("Agrega dos productos al carrito")
    public void Agrega_dos_productos_al_carrito() {
        productPage.agregarDesdeHover();
        productPage.agregarProductoDesdeDetalles();
    }

    @When("Accede al carrito y elimina el ultimo producto")
    public void Accede_al_carrito_y_elimina_el_ultimo_producto() {
        cartPage.irAlCarritoDesdeMensajeEmergente();
        cartPage.eliminarUltimoProducto();
    }

    @Then("Deberia haber un unico producto en el carrito")
    public void Deberia_haber_un_unico_producto_en_el_carrito() {
        List<WebElement> productosEnCarrito = cartPage.obtenerProductosEnCarrito();
        Assert.assertEquals(productosEnCarrito.size(), 1, "Se esperaba un único producto en el carrito.");
    }

}
