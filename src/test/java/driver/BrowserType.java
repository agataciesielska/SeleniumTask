package driver;

public enum BrowserType {
    FIREFOX("firefox"),
    CHROME("chrome"),
    IE("internetexplorer");

    final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }
}
