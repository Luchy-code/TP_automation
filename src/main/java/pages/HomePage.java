package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    // Localizador del texto "Home" en la barra de navegación
    private final By homeNavLocator = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHomePage() {
        driver.get("https://automationexercise.com");
    }

    public String obtenerTextoHome() {
        return driver.findElement(homeNavLocator).getText();
    }

}
