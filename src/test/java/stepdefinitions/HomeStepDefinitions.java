package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;
import utils.BaseTest;

public class HomeStepDefinitions extends BaseTest {
    HomePage homePage;

    @Given("el usuario navega a la pagina de inicio")
    public void el_usuario_navega_a_la_pagina_de_inicio() {
        iniciarDriver();
        homePage = new HomePage(getDriver());
        homePage.goToHomePage();
    }

    @Then("Debera ver el mensaje {string}")
    public void debera_ver_el_mensaje(String mensajeEsperado) {
        String textoReal = homePage.obtenerTextoHome(); // Llama al método que obtiene el texto en la página
        Assert.assertTrue(textoReal.contains(mensajeEsperado),
                "El mensaje esperado no aparece. Se obtuvo: " + textoReal);
    }

}
