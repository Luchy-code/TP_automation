package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    WebDriver driver;

    // Localizadores
    WebDriverWait wait;
    private By btnAceptar = By.xpath("//*[@id='cartModal']/div/div/div[3]/button");
    private By linkCart = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
    private By productosEnCarrito = By.xpath("//tr[starts-with(@id,'product-')]");
    private By modalCarrito = By.id("cartModal");
    private By linkVerCarritoDesdeModal = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void aceptarPantallaEmergente() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement botonAceptar = wait.until(ExpectedConditions.elementToBeClickable(btnAceptar));
        botonAceptar.click();
    }

    public void irAlCarrito() {
        driver.get("https://automationexercise.com/view_cart");
    }

    public void eliminarUltimoProducto() {
        List<WebElement> productos = driver.findElements(By.xpath("//tr[starts-with(@id,'product-')]"));

        if (productos.size() > 1) {
            // Tomar el Ãºltimo producto visible
            WebElement ultimoProducto = productos.get(productos.size() - 1);
            WebElement botonEliminar = ultimoProducto.findElement(By.xpath(".//a[contains(@class,'cart_quantity_delete')]"));
            botonEliminar.click();

            // Esperar a que el producto se elimine
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.stalenessOf(ultimoProducto));
        }
        //WebElement btnEliminar = ultimo.findElement(By.xpath(".//a[@class='cart_quantity_delete']"));
    }

    public List<WebElement> obtenerProductosEnCarrito() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return driver.findElements(productosEnCarrito);
    }

    public void irAlCarritoDesdeMensajeEmergente() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Esperar que el modal sea visible
            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(modalCarrito));

            // Hacer clic en "View Cart" dentro del modal
            WebElement linkVerCarrito = wait.until(ExpectedConditions.elementToBeClickable(linkVerCarritoDesdeModal));
            linkVerCarrito.click();

        } catch (Exception e) {
            System.out.println("No se pudo hacer clic en 'View Cart' desde el modal: " + e.getMessage());
        }
    }
}
