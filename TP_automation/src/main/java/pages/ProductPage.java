package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstAddToCartButton = By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]");
    By viewCartButton = By.xpath("//u[normalize-space()='View Cart']");
    By confirmationModal = By.id("cartModal");
    By confirmationText = By.xpath("//div[@id='cartModal']//h4");

    public void clickAddToCart() {
        driver.findElement(firstAddToCartButton).click();
    }

    public String getConfirmationText() {
        return driver.findElement(confirmationText).getText();
    }

    public void clickViewCart() {
        driver.findElement(viewCartButton).click();
    }
}
