package steps.hooks;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import static driver.DriverManager.setupChrome;

public class baseHooks {

    DriverManager driverManager = new DriverManager();
    WebDriver driver;

    @Before
    public void beforeTest() {
        setupChrome();
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void afterTest() {
        driverManager.teardown();
        driver = null;
    }
}
