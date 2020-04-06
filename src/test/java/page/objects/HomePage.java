package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DatePicker;
import waits.WaitForElement;

import java.time.LocalDate;

public class HomePage extends BasePage {

    WebDriver driver = BasePage.getDriver();
    DatePicker datePicker = new DatePicker();
    public final int futureMonthsNumber = 10;

    @FindBy(css = "div.hero-form-inner")
    private WebElement searchBox;

    @FindBy(css = "div.hero-form-inner ul.row-reverse a.active")
    private WebElement searchType;

    @FindBy(css = "div.hero-form-inner ul.row-reverse a.flights")
    private WebElement flightsSearchType;

    @FindBy(css = "div#s2id_location_from")
    private WebElement flightsFromField;

    @FindBy(css = "div#s2id_location_to")
    private WebElement flightsToField;

    @FindBy(css = "ul.select2-results li.select2-highlighted")
    private WebElement highlightedCity;

    @FindBy(css = "div#flights div#airDatepickerRange-flight")
    private WebElement flightsDepartField;

    @FindBy(css = "div.datepicker.active div.datepicker--cell.-current-")
    private WebElement flightscurrentDay;

    @FindBy(css = "div.datepicker.active div[data-action=next]")
    private WebElement flightDepartNextMonth;

    @FindBy(css = "div.datepicker.active div.datepicker--nav-title")
    private WebElement flightsDatepickerTitle;

    @FindBy(css = "div.datepicker.active")
    private WebElement activeDatepicker;

    public boolean isSearchBoxVisible() {
        logger.debug("Checking if searchBox is visible");
        WaitForElement.waitUntilElementIsVisible(searchBox);
        return searchBox.isDisplayed();
    }

    public String getActiveSearchType() {
        return searchType.getText();
    }

    public WebElement getGivenSearchType(String tripType) {
        return driver.findElement(By.cssSelector("div.hero-form-inner ul.row-reverse a." + tripType.toLowerCase()));
    }

    public void fillFlightsFrom(String city) {
        flightsFromField.click();
        driver.findElement(By.cssSelector("input.select2-focused")).sendKeys(city);
        WaitForElement.waitUntilElementIsVisible(highlightedCity);
        highlightedCity.click();
    }

    public void fillFlightsTo(String city) {
        flightsToField.click();
        driver.findElement(By.cssSelector("input.select2-focused")).sendKeys(city);
        WaitForElement.waitUntilElementIsVisible(highlightedCity);
        highlightedCity.click();
    }

    public LocalDate getNowDatePlusWeeks(int weeks) {
        return datePicker.getDateInGivenWeeks(weeks);
    }

    public void switchCalendarViewToGivenDate(LocalDate date) throws InterruptedException {
        flightsDepartField.click();
        WaitForElement.waitUntilElementIsVisible(activeDatepicker);

        Thread.sleep(333);

        String activeMonthAndYear = flightsDatepickerTitle.getText().toUpperCase();

        String year = String.valueOf(date.getYear());
        String month = String.valueOf(date.getMonth());

        System.out.println(activeMonthAndYear);
        System.out.println("year: " + year);
        System.out.println("month: " + month);

        for (int i = 0; i < futureMonthsNumber; i++) {
            WaitForElement.waitUntilElementIsVisible(activeDatepicker);

            if (!(activeMonthAndYear.contains(year) && activeMonthAndYear.contains(month))) {
                flightDepartNextMonth.click();
            }
        }
        getGivenDateElement(date).click();
    }

    public WebElement getGivenDateElement(LocalDate date) throws InterruptedException {

        int day = date.getDayOfMonth();

        Thread.sleep(3333);

        return driver.findElement(By.cssSelector("div.datepicker.active div.datepicker--cell" +
                "[data-date='" + day + "']"));
    }
}
