package page.objects;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public Logger logger = LogManager.getLogger(this.getClass().getName());

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    Logger logger() {
        return logger;
    }

    public static WebDriver getDriver() {
       return DriverManager.getDriver();
    }
}
