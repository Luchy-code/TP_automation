package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.BaseTest;

public class LoginStepDefinitions extends BaseTest {

    LoginPage loginPage;

    @Given("El usuario accede a la pagina de login")
    public void El_usuario_accede_a_la_pagina_de_login() {
        iniciarDriver();
        loginPage = new LoginPage(getDriver());
        loginPage.goToHomePage();
    }

    @When("Ingresa su email y contrasena validos")
    public void Ingresa_su_email_y_contrasena_validos() {
        loginPage.ingresarEmail("lucianaoviedodanielawanuffelen@gmail.com");
        loginPage.ingresarPassword("1234");
    }

    @When("Hace clic en el boton de login")
    public void Hace_clic_en_el_boton_de_login() {
        loginPage.hacerClickLogin();
    }

    @Then("El usuario deberia ver su nombre de usuario en el menu de usuario {string}")
    public void el_usuario_deberia_ver_su_nombre_de_usuario_en_el_menu_de_usuario(String mensajeEsperado) {
        String textoReal = loginPage.obtenerTextoLoggedAs();
        System.out.println("averga: "+mensajeEsperado+" "+textoReal);
        Assert.assertTrue(textoReal.contains(mensajeEsperado),
                "El mensaje esperado no aparece. Se obtuvo: " + textoReal);
    }

}
