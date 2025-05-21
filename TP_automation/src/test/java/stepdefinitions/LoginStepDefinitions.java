package stepdefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinitions {

	WebDriver driver;
	LoginPage loginPage;

    @Given("El usuario accede a la página de login")
    public void el_usuario_accede_a_la_página_de_login() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/login");
        loginPage = new LoginPage(driver);
    }

    @When("Ingresa su email y contraseña válidos")
    public void ingresa_su_email_y_contraseña_válidos() {
    	  loginPage.ingresarEmail("lucianaoviedodanielawanuffelen@gmail.com");
          loginPage.ingresarPassword("1234");
    }

    @When("Hace clic en el botón de login")
    public void hace_clic_en_el_botón_de_login() {
    	 loginPage.hacerClickLogin();
    }

    @Then("Debería ver el mensaje {string}")
    public void debería_ver_el_mensaje(String mensajeEsperado) {
    	String textoReal = loginPage.obtenerTextoLoggedAs();
        assertTrue(textoReal.contains(mensajeEsperado), "El mensaje esperado no aparece.");
        driver.quit();
    }
   
}
