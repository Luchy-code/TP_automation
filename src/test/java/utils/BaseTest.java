package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class BaseTest {
    protected static WebDriver driver;

    @BeforeTest
    public static void iniciarDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void cerrarDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    @AfterTest
    public void cerrarEscenario() {
        cerrarDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
