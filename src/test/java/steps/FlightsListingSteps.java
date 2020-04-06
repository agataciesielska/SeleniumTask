package steps;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import page.objects.FlightsListingPage;

public class FlightsListingSteps {

    private FlightsListingPage flightsListingPage = new FlightsListingPage();

    @Then("^listing presents offers (.*) to (.*)$")
    public void listingPresentsOffersFromSCToToSC(String departure, String destination) {
        Assert.assertEquals(flightsListingPage.getListingTitleDeparture(), departure);
        Assert.assertEquals(flightsListingPage.getListingTitleDestination(), destination);
    }

    @Then("listing presents ascending sorting by price")
    public void listingPresentsAscendingSortingByPrice() {
        Assert.assertTrue(flightsListingPage.isListSortedAsc(flightsListingPage.getListingPrices()));
    }
}
