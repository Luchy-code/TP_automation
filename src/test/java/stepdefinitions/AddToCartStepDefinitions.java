package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import utils.BaseTest;

public class AddToCartStepDefinitions extends BaseTest{

    WebDriver driver;
    ProductPage productPage;

    @Given("El usuario accede a la pagina principal")
    public void El_usuario_accede_a_la_pagina_principal() {
        BaseTest.iniciarDriver();
        driver = BaseTest.getDriver();
        driver.get("https://automationexercise.com"); //url
        productPage = new ProductPage(driver);
    }

    @When("Agrega el primer producto al carrito con hover")
    public void Agrega_el_primer_producto_al_carrito_con_hover() {
        productPage.agregarDesdeHover();
    }

    @When("Ingresa a la pagina de detalles del primer producto y lo agrega al carrito")
    public void Ingresa_a_la_pagina_de_detalles_del_primer_producto_y_lo_agrega_al_carrito() {
        productPage.agregarProductoDesdeDetalles();
    }

    @Then("Deberia ver el mensaje de confirmacion {string}")
    public void Deberia_ver_el_mensaje_de_confirmacion(String mensajeEsperado) {
        boolean aparece = productPage.mensajeDeConfirmacionVisible(mensajeEsperado);
        Assert.assertTrue(aparece, "No se encontró el mensaje esperado: " + mensajeEsperado);
    }

}
