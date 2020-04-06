package steps;

import driver.DriverManager;
import io.cucumber.java.en.Given;

public class GlobalSteps {

    @Given("^navigate to (.*) phptravels$")
    public void navigateToMainPagePhptravels(String subpage) {
        DriverManager.getDriver().get("https://www.phptravels.net/");
    }
}
