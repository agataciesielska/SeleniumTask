package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightsListingPage extends BasePage {

    @FindBy(css = ".heading-title > span")
    private WebElement listingTitleDeparture;

    @FindBy(css = ".heading-title span.text-primary")
    private WebElement listingTitleDestination;

    public String getFirstWord(String text) {
        return text.substring(0, text.indexOf(" "));
    }

    public String getListingTitleDeparture() {
        return getFirstWord(listingTitleDeparture.getText());
    }

    public String getListingTitleDestination() {
        return listingTitleDestination.getText();
    }
}
