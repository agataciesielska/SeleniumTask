package page.objects;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DatePicker;
import waits.WaitForElement;

import java.time.LocalDate;

public class HomePage extends BasePage {

    private DatePicker datePicker = new DatePicker();

    @FindBy(css = "div.hero-form-inner")
    private WebElement searchBox;

    @FindBy(css = "div#cookyGotItBtnBox button")
    private WebElement acceptCookiesButton;

    @FindBy(css = "div.hero-form-inner ul.row-reverse a.active")
    private WebElement searchType;

    @FindBy(css = "div#flights button.btn-primary")
    private WebElement flightsSearchButton;

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

    @FindBy(css = "input[name='fadults']")
    private WebElement flightsAdultCounter;

    @FindBy(css = "input[name='fchildren']")
    private WebElement flightsChildCounter;

    @FindBy(css = "input[name='finfant']")
    private WebElement flightsInfantCounter;

    @FindBy(xpath = "//input[@name='fadults']/following-sibling::*[1][name()='span']/button[.='+']")
    private WebElement flightsPlusAdultButton;

    @FindBy(xpath = "//input[@name='fadults']/following-sibling::*[1][name()='span']/button[.='-'] ")
    private WebElement flightsMinusAdultButton;

    @FindBy(xpath = "//input[@name='fchildren']/following-sibling::*[1][name()='span']/button[.='+'] ")
    private WebElement flightsPlusChildButton;

    @FindBy(xpath = "//input[@name='fchildren']/following-sibling::*[1][name()='span']/button[.='-'] ")
    private WebElement flightsMinusChildButton;

    @FindBy(xpath = "//input[@name='finfant']/following-sibling::*[1][name()='span']/button[.='+'] ")
    private WebElement flightsPlusInfantButton;

    @FindBy(xpath = "//input[@name='finfant']/following-sibling::*[1][name()='span']/button[.='-'] ")
    private WebElement flightsMinusInfantButton;

    public boolean isSearchBoxVisible() {
        logger.debug("Checking if searchBox is visible");
        WaitForElement.waitUntilElementIsVisible(searchBox);
        return searchBox.isDisplayed();
    }

    public void acceptCookies() {
        WaitForElement.waitUntilElementIsVisible(acceptCookiesButton);
        if (acceptCookiesButton.isDisplayed()) {
            acceptCookiesButton.click();
        }
    }

    public String getActiveSearchType() {
        return searchType.getText();
    }

    public WebElement getGivenSearchType(String tripType) {
        return DriverManager.getDriver().findElement(By.cssSelector("div.hero-form-inner ul.row-reverse a." + tripType.toLowerCase()));
    }

    public void fillFlightsFrom(String city) {
        flightsFromField.click();
        DriverManager.getDriver().findElement(By.cssSelector("input.select2-focused")).sendKeys(city);
        WaitForElement.waitUntilElementIsVisible(highlightedCity);
        highlightedCity.click();
    }

    public void fillFlightsTo(String city) {
        flightsToField.click();
        DriverManager.getDriver().findElement(By.cssSelector("input.select2-focused")).sendKeys(city);
        WaitForElement.waitUntilElementIsVisible(highlightedCity);
        highlightedCity.click();
    }

    public LocalDate getNowDatePlusWeeks(int weeks) {
        return datePicker.getDateInGivenWeeks(weeks);
    }

    public String getUpperString(WebElement element) {
        return element.getText().toUpperCase();
    }

    public WebElement getDay(LocalDate date) {

        int day = date.getDayOfMonth();

        return DriverManager.getDriver().findElement(By.cssSelector("div.datepicker.active div.datepicker--cell" +
                "[data-date='" + day + "']"));
    }

    public void setCalendarMonth(LocalDate date) {
        final int futureMonthsNumber = 10;

        flightsDepartField.click();
        WaitForElement.waitUntilElementIsVisible(activeDatepicker);

        String year = String.valueOf(date.getYear());
        String month = String.valueOf(date.getMonth());

        for (int i = 0; i < futureMonthsNumber; i++) {
            WaitForElement.waitUntilElementIsVisible(activeDatepicker);

            if (!(getUpperString(flightsDatepickerTitle).contains(year) && getUpperString(flightsDatepickerTitle).contains(month))) {
                flightDepartNextMonth.click();
            } else {
                break;
            }
        }
    }

    private void setPassengers(int passengers, WebElement counter, WebElement counterMinus, WebElement counterPlus) {
        int currentCounter = Integer.parseInt(counter.getAttribute("value"));

        while (passengers != currentCounter) {
            if (currentCounter > passengers) {
                counterMinus.click();
            } else {
                counterPlus.click();
            }
            currentCounter = Integer.parseInt(counter.getAttribute("value"));
        }
    }

    public void setFlightAdults(int adultsNumber) {
        setPassengers(adultsNumber, flightsAdultCounter, flightsMinusAdultButton, flightsPlusAdultButton);
    }

    public void setFlightsChildren(int childrenNumber) {
        setPassengers(childrenNumber, flightsChildCounter, flightsMinusChildButton, flightsPlusChildButton);
    }

    public void setFlightsInfants(int infantsNumber) {
        setPassengers(infantsNumber, flightsInfantCounter, flightsMinusInfantButton, flightsPlusInfantButton);
    }

    public void submitFlightsSearchBox() {
        WaitForElement.waitUntilElementIsVisible(flightsSearchButton);
        flightsSearchButton.click();
    }
}
