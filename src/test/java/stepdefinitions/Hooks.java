package stepdefinitions;
import io.cucumber.java.After;
import utils.BaseTest;

public class Hooks extends BaseTest {

    @After
    public void cerrarDriverDespuesDeCadaEscenario() {
        cerrarDriver();  // Llama al método de BaseTest
    }
}
