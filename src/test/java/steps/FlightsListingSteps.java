package steps;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import page.objects.FlightsListingPage;

public class FlightsListingSteps {

    FlightsListingPage flightsListingPage = new FlightsListingPage();

    @Then("^listing presents offers (.*) to (.*)$")
    public void listingPresentsOffersFromSCToToSC(String departure, String destination) {
        Assert.assertEquals(flightsListingPage.getListingTitleDeparture(), departure);
        Assert.assertEquals(flightsListingPage.getListingTitleDestination(), destination);
    }

    @Then("listing presents ascending sorting by price")
    public void listingPresentsAscendingSortingByPrice() {

    }
}
