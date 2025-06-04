package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {

    private WebDriver driver;

    private By emailInput = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
    private By passwordInput = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]");
    private By loginButton = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
    private By loggedAsText = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"); //logged as nombre

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ingresarEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void ingresarPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void hacerClickLogin() {
        driver.findElement(loginButton).click();
    }

    public String obtenerTextoLoggedAs() {
        return driver.findElement(loggedAsText).getText();
    }

    public void goToHomePage() {
        driver.get("https://automationexercise.com/login");
    }

}
