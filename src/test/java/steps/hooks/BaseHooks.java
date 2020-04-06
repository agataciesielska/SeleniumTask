package steps.hooks;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverManager;

import java.util.Properties;


public class BaseHooks {

    @Before
    public void beforeTest() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties properties = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(properties);
        DriverManager.getDriver().manage().window().maximize();
    }

    @After
    public void afterTest() {
        DriverManager.teardown();
    }
}
