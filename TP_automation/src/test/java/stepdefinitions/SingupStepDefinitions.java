package stepdefinitions;
import org.openqa.selenium.By;
import org.testng.Assert;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SignupPage;
import utils.BaseTest;

public class SingupStepDefinitions {

    WebDriver driver;
    SignupPage signupPage;

    @Given("El usuario accede a la página de registro")
    public void el_usuario_accede_a_la_página_de_registro() {
        BaseTest.iniciarDriver();
        driver = BaseTest.getDriver();
        driver.get("https://automationexercise.com/login");
        signupPage = new SignupPage(driver);
    }

    @When("Ingresa los datos requeridos")
    public void ingresa_los_datos_requeridos() {
        // Paso 1: nombre y correo
        signupPage.completarSignupInicial("luchi2", "lucianaoviedodanielawanuffelen2@gmail.com");

        // Paso 2: formulario de cuenta
        signupPage.completarFormularioCuenta("1234");

        // Paso 3: datos de dirección
        signupPage.completarFormularioDireccion();

        // Paso 4: crear cuenta
        signupPage.clickCrearCuenta();
    }

    @Then("Debería ver el mensaje {string}")
    public void debería_ver_el_mensaje(String mensajeEsperado) {
        By loggedInMessageLocator = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
        String textoReal = driver.findElement(loggedInMessageLocator).getText();
        Assert.assertTrue(textoReal.contains(mensajeEsperado), 
            "El mensaje esperado no aparece. Se obtuvo: " + textoReal);
    }
}
