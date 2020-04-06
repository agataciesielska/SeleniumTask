package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import page.objects.HomePage;

import java.time.LocalDate;

public class HomePageSteps {

    private HomePage homePage = new HomePage();

    @Then("searchBar is visible")
    public void searchbarIsVisible() {
        Assert.assertTrue(homePage.isSearchBoxVisible());
    }

    @When("^I choose (.*) search type$")
    public void chooseSearchType(String searchType) {
        homePage.getGivenSearchType(searchType).click();
        Assert.assertEquals(homePage.getActiveSearchType(), searchType);
    }

    @And("^fill From field with (.*)$")
    public void fillFromFieldWithText(String city) {
        homePage.fillFlightsFrom(city);
    }

    @And("^fill To field with (.*)$")
    public void fillToFieldWithText(String city) {
        homePage.fillFlightsTo(city);
    }

    @And("^fill Depart date in (.*) weeks$")
    public void fillDepartFieldWithDepart(int weeks) {

        LocalDate date = homePage.getNowDatePlusWeeks(weeks);

        homePage.setCalendarMonth(date);
        homePage.getDay(date).click();
    }

    @And("^fill Adult field with (.*)$")
    public void fillAdultFieldWith(int adultsNumber) {
        homePage.setFlightAdults(adultsNumber);
    }

    @And("^fill Child field with (.*)$")
    public void fillChildFieldWith(int childrenNumber) {
        homePage.setFlightsChildren(childrenNumber);
    }

    @And("^fill Infant field with (.*)$")
    public void fillInfantFieldWith(int infantNumber) {
        homePage.setFlightsChildren(infantNumber);
    }

    @And("click search button")
    public void clickSearchButton() {
        homePage.submitFlightsSearchBox();
    }

    @And("accept cookies")
    public void acceptCookies() {
        homePage.acceptCookies();
    }
}
