package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

import pages.ProductPage;
import pages.CartPage;

public class AddToCartStepDefinitions {

    WebDriver driver;
    ProductPage productPage;
    CartPage cartPage;

    @Given("El usuario está en una página de producto")
    public void el_usuario_está_en_una_página_de_producto() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/products");
        productPage = new ProductPage(driver);
    }

    @When("Hace clic en {string}")
    public void hace_clic_en(String boton) {
        if (boton.equalsIgnoreCase("Add to cart")) {
            productPage.clickAddToCart();
        }
    }

    @Then("Debería ver una confirmación del agregado")
    public void debería_ver_una_confirmación_del_agregado() {
        String confirm = productPage.getConfirmationText();
        assertTrue(confirm.contains("Added"), "El mensaje no contiene 'Added'");
        productPage.clickViewCart();
    }

    @Then("El producto debería aparecer en el carrito")
    public void el_producto_debería_aparecer_en_el_carrito() {
        cartPage = new CartPage(driver);
        String producto = cartPage.getProductName();
        assertNotNull(producto, "El producto no está en el carrito");
        assertFalse(producto.isEmpty(), "El nombre del producto está vacío");
        driver.quit();
    }
}
