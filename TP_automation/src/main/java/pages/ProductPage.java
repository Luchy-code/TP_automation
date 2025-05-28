package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    private By contenedorHoverProducto = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]");
    private By botonAgregarHover = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[2]/div/a");
    private By linkVerDetalleProducto = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a");
    private By botonAgregarDesdeDetalle = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");
    private By mensajeConfirmacionModal = By.xpath("//*[@id='cartModal']/div/div/div[1]/h4");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void agregarDesdeHover() {
        Actions actions = new Actions(driver);
        WebElement contenedorProducto = driver.findElement(contenedorHoverProducto);
        actions.moveToElement(contenedorProducto).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement botonAgregar = wait.until(ExpectedConditions.elementToBeClickable(botonAgregarHover));
        botonAgregar.click();
    }

    public void agregarProductoDesdeDetalles() {
        WebElement verProducto = driver.findElement(linkVerDetalleProducto);
        verProducto.click();

        WebElement botonAgregar = driver.findElement(botonAgregarDesdeDetalle);
        botonAgregar.click();
    }

    public boolean mensajeDeConfirmacionVisible(String textoEsperado) {
        WebElement mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(mensajeConfirmacionModal));
        return mensaje.getText().toLowerCase().contains(textoEsperado.toLowerCase());
    }
}
