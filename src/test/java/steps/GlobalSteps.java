package steps;

import configuration.AppProperties;
import driver.DriverManager;
import cucumber.api.java.en.Given;

public class GlobalSteps {

    @Given("^navigate to main page phptravels$")
    public void navigateToMainPagePhptravels() {
        DriverManager.getDriver().get(AppProperties.getAppUrl());
    }
}
