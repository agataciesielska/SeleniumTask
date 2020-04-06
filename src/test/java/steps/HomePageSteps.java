package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.objects.HomePage;

public class HomePageSteps {

    HomePage homePage = new HomePage();

    @Then("searchBar is visible")
    public void searchbarIsVisible() {
        Assert.assertTrue(homePage.isSearchBoxVisible());
    }

    @When("^user chooses (.*) search type$")
    public void userClicksOnFlightsSearchType(String searchType) {
        homePage.getGivenSearchType(searchType).click();
        Assert.assertEquals(homePage.getActiveSearchType(), searchType);
    }

    @And("^user fill From field with (.*)$")
    public void userFillFromFieldWithText(String city) {
        homePage.fillFlightsFrom(city);
    }

    @And("^user fill To field with (.*)$")
    public void userFillToFieldWithText(String city) {
        homePage.fillFlightsTo(city);
    }

    @And("^user fill Depart date in (.*) weeks$")
    public void userFillDepartFieldWithDepart(int weeks) throws InterruptedException {
        homePage.switchCalendarViewToGivenDate(homePage.getNowDatePlusWeeks(weeks));
        homePage.getGivenDateElement(homePage.getNowDatePlusWeeks(weeks)).click();
    }
}
