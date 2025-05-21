package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {
    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    // Signup inicial
    By nameInput = By.name("name");
    By emailInput = By.xpath("//input[@data-qa='signup-email']");
    By signupButton = By.xpath("//button[@data-qa='signup-button']");

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
    By createAccountButton = By.xpath("//button[normalize-space()='Create Account']");

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

    public void clickCrearCuenta() {
        driver.findElement(createAccountButton).click();
    }
}
