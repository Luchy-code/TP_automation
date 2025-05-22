package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeTest
    public static void iniciarDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public static void cerrarDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
