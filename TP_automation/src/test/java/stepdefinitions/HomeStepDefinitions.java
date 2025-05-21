package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import utils.BaseTest;

public class HomeStepDefinitions extends BaseTest {
	 WebDriver driver;

	    @Given("El usuario accede a la página principal")
	    public void el_usuario_accede_a_la_página_principal() {
	        BaseTest.iniciarDriver();
	        driver = BaseTest.getDriver();
	        driver.get("https://automationexercise.com/");
	    }

	    @Then("Debería ver el título de la página {string}")
	    public void debería_ver_el_título_de_la_página(String tituloEsperado) {
	        String tituloActual = driver.getTitle();
	        if (!tituloActual.equals(tituloEsperado)) {
	            throw new AssertionError("El título no coincide. Se esperaba: " + tituloEsperado + ", pero fue: " + tituloActual);
	        }
	        BaseTest.cerrarDriver(); // Cerramos al final
	    }

}

