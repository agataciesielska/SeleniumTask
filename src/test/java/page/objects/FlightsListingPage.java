package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class FlightsListingPage extends BasePage {

    @FindBy(css = ".heading-title > span")
    private WebElement listingTitleDeparture;

    @FindBy(css = ".heading-title span.text-primary")
    private WebElement listingTitleDestination;

    @FindAll(@FindBy(css = "theme-search-results-item-price-tag strong"))
    private List<WebElement> listingPricesElements;

    public String getFirstWord(String text) {
        return text.substring(0, text.indexOf(" "));
    }

    public String getSecondWord(String text) {
        return text.substring(text.indexOf(" ") + 1, text.length());
    }

    public String getListingTitleDeparture() {
        return getFirstWord(listingTitleDeparture.getText());
    }

    public String getListingTitleDestination() {
        return listingTitleDestination.getText();
    }

    public List<Integer> getListingPrices() {

        List<Integer> listingPrices = new ArrayList<>();

        for (WebElement element : listingPricesElements) {
            int price = Integer.parseInt(getSecondWord(element.getText()));
            listingPrices.add(price);
        }
        return listingPrices;
    }

    public boolean isListSortedAsc(List<Integer> givenList) {
        for (int i = 0; i < givenList.size() - 1; i++) {
            if (givenList.get(i) > givenList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
