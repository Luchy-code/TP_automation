package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utils.BaseTest;

public class CommonStepDefinitions {

    //cosas en comun pq sale error de duplicidad

    @Then("Debera ver el texto {string} en el elemento {string}")
    public void debera_ver_el_texto_en_el_elemento(String textoEsperado, String xpathElemento) {
        WebDriver driver = BaseTest.getDriver();
        By elementLocator = By.xpath(xpathElemento);

        String textoReal = driver.findElement(elementLocator).getText();
        Assert.assertTrue(textoReal.contains(textoEsperado),
                "El mensaje esperado no aparece. Se obtuvo: " + textoReal);
    }

}
