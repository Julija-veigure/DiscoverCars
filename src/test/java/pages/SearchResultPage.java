package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {
    private final Logger LOGGER = (Logger) LogManager.getLogger(this.getClass());
    private final BaseFunctions baseFunctions;
    private final Searching searching;

    private final By CHANGE_SRC_BTN = By.xpath(".//a[@class = 'change-search trigger-gtm-change-search']");
    private final By SPECIAL_OFFERS = By.xpath(".//span[@class = 'category-label trend']");
    private final By SPEC_OFFER_ZERO_DEPOSIT = By.id("filter-special-offers-zero-deposit");
    private final By REMOVE_ALL_FILTERS = By.xpath(".//a[@class = 'clear-filter btn show']");
    private final String special_offer_text = "Special offers";
    private final By SORTING_BY = By.xpath(".//div[@class = 'dc-ui dropdown inline-block']");
    private final By SORTING_BY_VALUE = By.xpath(".//li[@data-event-label= 'Value']");
    //    private final By CAR_BOX_LIST = By.xpath(".//div[@class = 'car-box filtered']");
    private final By CAR_BOX_LIST = By.xpath(".//div[@class = 'car-box']");
    //    private final By VIEW_BTN = By.xpath(".//a[@class = 'btn btn-book submit click-on-car selected-car prevent-loading instant']");
    private final By VIEW_BTN = By.xpath(".//div[@class = 'ca-table-cell top']");

    public SearchResultPage(BaseFunctions baseFunctions, Searching searching) {
        this.baseFunctions = baseFunctions;
        this.searching = searching;
    }

    public void changeSearchRequest() {
        baseFunctions.click(CHANGE_SRC_BTN);
        LOGGER.info("Change button is clicked");
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
        LOGGER.info("Pick up time is changed");
    }

    public void searchByNewParam() {
        baseFunctions.loadingAllResults(searching.SEARCH_NOW_BTN, searching.ADDITIONAL_FILTERS);
        LOGGER.info("Searching results after parameters update");
    }

    public void specOfferSelect() {
        baseFunctions.click(SPEC_OFFER_ZERO_DEPOSIT);
        LOGGER.info("Special offers is selected");
    }

    public void checkSpecialOffers() {
        String spec_offers_title = baseFunctions.getText(SPECIAL_OFFERS);
        baseFunctions.pleaseAssert(special_offer_text, spec_offers_title);
    }


    public void removeAllFilters() {
        baseFunctions.click(REMOVE_ALL_FILTERS);
        LOGGER.info("All filters are removed");
    }

    public void sortBy() {
        baseFunctions.click(SORTING_BY);
        baseFunctions.findElement(SORTING_BY_VALUE).click();
        LOGGER.info("Sorting is selected by value - Price/rating");
    }

    public void selectCar() {
        baseFunctions.findElements(CAR_BOX_LIST).get(0).findElements(VIEW_BTN).get(0).click();
        LOGGER.info("Car is selected");

    }

//    public void selectCar() {
//        baseFunctions.findElements(SEARCH_RESULT_LIST).get(0).click();
//    }


}
