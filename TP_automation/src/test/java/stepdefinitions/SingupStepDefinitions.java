package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.SignupPage;
import utils.BaseTest;

public class SingupStepDefinitions  extends BaseTest {

    WebDriver driver;
    SignupPage signupPage;

    @Given("El usuario accede a la pagina de registro")
    public void el_usuario_accede_a_la_pagina_de_registro() {
        BaseTest.iniciarDriver();
        driver = BaseTest.getDriver();
        driver.get("https://automationexercise.com/login"); //url
        signupPage = new SignupPage(driver);
    }

    @When("Ingresa los datos requeridos")
    public void ingresa_los_datos_requeridos() {
        String email;
        boolean emailExistente;

        do {
            email = "lucianaoviedodanielawanuffelen" + signupPage.getRandom() + "@gmail.com";
            signupPage.completarSignupInicial("luchi2", email);
            emailExistente = signupPage.emailYaExiste();
        } while (emailExistente);

        signupPage.completarFormularioCuenta("1234");
        signupPage.completarFormularioDireccion();
    }

    @And("Hace clic en {string}")
    public void hace_clic_en(String textoBoton) {
        signupPage.clickCrearCuenta();
    }

    @Then("El nuevo usuario deberia ver el mensaje de confirmacion {string}")
    public void el_nuevo_usuario_deberia_ver_el_mensaje_de_confirmacion(String mensajeEsperado) {
        String textoReal = signupPage.obtenerTextoHome();
        Assert.assertTrue(textoReal.contains(mensajeEsperado),
                "El mensaje esperado no aparece. Se obtuvo: " + textoReal);
    }

}
