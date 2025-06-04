package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class SignupPage {
    Random random;
    WebDriver driver;
    WebDriverWait wait;

    public SignupPage(WebDriver driver) {
        random = new Random();
        this.driver = driver;
    }

    // Elementos de la página de registro
    By nameInput = By.name("name");
    By emailInput = By.xpath("//input[@data-qa='signup-email']");
    By signupButton = By.xpath("//button[@data-qa='signup-button']");
    By errorMessage = By.xpath("//*[@id='form']/div/div/div[3]/div/form/p");

    // Formulario de cuenta
    By titleMrs = By.id("id_gender2");
    By passwordInput = By.id("password");
    By daysSelect = By.id("days");
    By monthsSelect = By.id("months");
    By yearsSelect = By.id("years");

    // Dirección
    By firstNameInput = By.id("first_name");
    By lastNameInput = By.id("last_name");
    By addressInput = By.id("address1");
    By countrySelect = By.id("country");
    By stateInput = By.id("state");
    By cityInput = By.id("city");
    By zipcodeInput = By.id("zipcode");
    By mobileInput = By.id("mobile_number");

    // Botón de crear cuenta
    By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");

    // Mensaje satisfactorio en la página de inicio
    By loggedInMessageLocator = By.xpath("//*[@id=\"form\"]/div/div/div/h2");

    public void completarSignupInicial(String nombre, String email) {
        driver.findElement(nameInput).sendKeys(nombre);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(signupButton).click();
    }

    public void completarFormularioCuenta(String password) {
        driver.findElement(titleMrs).click();
        driver.findElement(passwordInput).sendKeys(password);
        new Select(driver.findElement(daysSelect)).selectByValue("10");
        new Select(driver.findElement(monthsSelect)).selectByValue("5");
        new Select(driver.findElement(yearsSelect)).selectByValue("1990");
    }

    public void completarFormularioDireccion() {
        driver.findElement(firstNameInput).sendKeys("Luciana");
        driver.findElement(lastNameInput).sendKeys("Oviedo");
        driver.findElement(addressInput).sendKeys("Av. Siempre Viva 123");
        new Select(driver.findElement(countrySelect)).selectByVisibleText("India");
        driver.findElement(stateInput).sendKeys("Delhi");
        driver.findElement(cityInput).sendKeys("Delhi");
        driver.findElement(zipcodeInput).sendKeys("110001");
        driver.findElement(mobileInput).sendKeys("1234567890");
    }

    public String getRandom() {
        return Integer.toString(random.nextInt(1000));
    }

    public void clickCrearCuenta() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        boton.click();
    }

    public boolean emailYaExiste() {
        try {
            String errorText = driver.findElement(errorMessage).getText();
            return errorText.contains("Email Address already exist!");
        } catch (Exception e) {
            return false;
        }
    }

    public String obtenerTextoHome() {
        return driver.findElement(loggedInMessageLocator).getText();
    }
}
