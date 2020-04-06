package driver;

import configuration.AppProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager {
    private static WebDriver driver;

    private static final BrowserType BROWSER_TYPE = AppProperties.getBrowser();

    private DriverManager() {

    }

    private static WebDriver getBrowser() {
        switch (BROWSER_TYPE) {
            case IE:
                WebDriverManager.iedriver().setup();
                driver =  new InternetExplorerDriver();
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver =  new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver =  new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Unknown browser type! Please check your configuration");
        }

        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = getBrowser();
        }
        return driver;
    }

    public static void teardown() {
        driver.close();
        if (!BROWSER_TYPE.equals(BrowserType.FIREFOX)) {
            driver.quit();
        }
        driver = null;
    }
}