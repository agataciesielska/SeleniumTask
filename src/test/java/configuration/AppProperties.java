package configuration;

import driver.BrowserType;

public class AppProperties {

    public static String getAppUrl() {
        return ConfigurationProperties.getProperties().getProperty("app.url");
    }

    public static BrowserType getBrowser() {
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("browser"));
    }

}
