package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void agregarDesdeHover() {
        Actions actions = new Actions(driver);

        // 1. Hacer hover sobre el contenedor del producto
        WebElement contenedorProducto = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]"));
        actions.moveToElement(contenedorProducto).perform();

        // 2. Esperar que el botón "Add to cart" sea visible y clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By botonAgregarXPath = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[2]/div/a");
        WebElement botonAgregar = wait.until(ExpectedConditions.elementToBeClickable(botonAgregarXPath));

        // 3. Hacer clic
        botonAgregar.click();
    }


    // 2. Agregar producto desde la página de detalles
    public void agregarProductoDesdeDetalles() {
        // Ir al detalle del producto
        WebElement verProducto = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[2]/ul/li/a"));
        verProducto.click();

        // Clic en botón "Add to cart" en la página de producto
        WebElement botonAgregar = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button"));
        botonAgregar.click();
    }

    // Confirmación por alerta modal
    public boolean mensajeDeConfirmacionVisible(String textoEsperado) {
        WebElement mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cartModal']/div/div/div[1]/h4")));
        return mensaje.getText().toLowerCase().contains(textoEsperado.toLowerCase());
    }
}
