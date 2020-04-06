package steps;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class GlobalSteps {

    WebDriver driver = DriverManager.getDriver();

    @Given("^navigate to main page phptravels$")
    public void navigateToMainPagePhptravels() {
        driver.get("https://www.phptravels.net/");
    }
}
