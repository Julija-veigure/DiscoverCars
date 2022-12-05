package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SearchResultPage {
    private final Logger LOGGER = (Logger) LogManager.getLogger(this.getClass());
    private final BaseFunctions baseFunctions;
    private final Searching searching;

    private final By CHANGE_SRC_BTN = By.xpath(".//a[@class = 'change-search trigger-gtm-change-search']");
    private final By SPECIAL_OFFERS = By.xpath(".//span[@class = 'category-label trend']");
    private final By SPEC_OFFER_ZERO_DEPOSIT = By.id("filter-special-offers-zero-deposit");
    private final By REMOVE_ALL_FILTERS = By.xpath(".//a[@class = 'clear-filter btn show']");
    private final String special_offer_text = "Special offers";

    public SearchResultPage(BaseFunctions baseFunctions, Searching searching) {
        this.baseFunctions = baseFunctions;
        this.searching = searching;
    }

    public void changeSearchRequest() {
        baseFunctions.click(CHANGE_SRC_BTN);
    }

    public void pickUpLocationChanging() {
        WebElement pickUpLocation = baseFunctions.findElement(searching.PICK_UP_LOCATION);
        baseFunctions.typeIn(searching.PICK_UP_LOCATION, "Barcelona");
        baseFunctions.pleaseWaitElement(searching.PICK_UP_LOCATION_LIST);
        pickUpLocation.sendKeys(Keys.ARROW_DOWN);
        pickUpLocation.sendKeys(Keys.ENTER);
                LOGGER.info("Pick up location is changed");
    }
    public void pickUpTimeChanging() {
        baseFunctions.click(searching.PICK_UP_TIME_FIELD);
        baseFunctions.findElements(searching.TIME_LIST).get(13).click();
    }
    public void searchByNewPharam() {
        baseFunctions.loadingAllResults(searching.SEARCH_NOW_BTN, searching.ADDITIONAL_FILTERS);
    }



    public void specOfferSelect() {
        baseFunctions.click(SPEC_OFFER_ZERO_DEPOSIT);
    }

    public void checkSpecialOffers() {
        String spec_offers_title = baseFunctions.getText(SPECIAL_OFFERS);
        baseFunctions.pleaseAssert(special_offer_text, spec_offers_title);
    }


    public void removeAllFilters() {
        baseFunctions.click(REMOVE_ALL_FILTERS);
    }


}
