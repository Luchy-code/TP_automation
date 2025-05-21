package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By productName = By.xpath("//td[@class='cart_description']//a");

    public String getProductName() {
        return driver.findElement(productName).getText();
    }
}
