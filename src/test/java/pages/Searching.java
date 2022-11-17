package pages;

import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class Searching {
    private final Logger LOGGER = (Logger) LogManager.getLogger(this.getClass());
    private BaseFunctions baseFunctions;


    private final By UNABLE_TO_FIND_LOCATION = By.xpath(".//div[@class = 'not-found-message hide']");
    private final By SEARCH_NOW_BTN = By.xpath(".//button[@id = 'location-submit']");
    private final By WARN_MSG = By.xpath(".//ul[@class = 'error-list']");
    public String WARNING_MSG_PICK_UP = "Select a pick-up location";
    private final By PICK_UP_LOCATION = By.xpath(".//input[@Id = 'pick-up-location']");
    private final By PICK_UP_LOCATION_LIST = By.xpath(".//div[@class= 'location-item airport tt-suggestion tt-selectable']");
    private final By PICK_UP_DATE = By.xpath(".//input[@id = 'pick-date-ui']");
    private final By PICK_UP_TIME = By.xpath(".//div[@id = 'pick_time_chosen']");
    private final By PICK_UP_TIME_LIST = By.xpath(".//ul[@class = 'chosen-results']");
    private final By PICK_UP_NEXT_MONTH = By.xpath(".//a[@class = 'ui-datepicker-next ui-corner-all']");
    private final By PICK_UP_DATE_LIST = By.xpath(".//a[@class = 'ui-state-default']");
    private final By LOCATION_CHECK_BOX = By.xpath(".//label[@for = 'is-drop-off']");
    public String WARNING_MSG_DROP_OFF = "Select a drop-off location";
    private final By DROP_OFF_LOCATION = By.xpath(".//input[@id= 'drop-off-location']");
    private final By DROP_OFF_LOCATION_LIST = By.xpath(".//div[@class= 'location-item airport tt-suggestion tt-selectable']");
    private final By DROP_OFF_DATE = By.xpath(".//input[@id = 'drop-date-ui']");
    private final By DROP_OFF_TIME = By.xpath(".//div[@id = 'drop_time_chosen']");
    private final By SPECIAL_OFFERS = By.xpath(".//span[@class = 'category-label trend']");

    public String UNABLE_TO_FIND_ANY_LOCATION = "Unable to find any location";


    public Searching(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void search() {
        baseFunctions.click(SEARCH_NOW_BTN);
        LOGGER.info("Search now btn ...");
    }

    public void loadingAllResults() {
        baseFunctions.click(SEARCH_NOW_BTN);
        baseFunctions.pleaseWaitElement(SPECIAL_OFFERS);
    }

    public String giveWarningMsg() {
        LOGGER.info("Search without location, checking for warning message");
        return baseFunctions.getText(WARN_MSG);
    }

    public void selectPickUpLocation() {
        WebElement pickUpLocation = baseFunctions.findElement(PICK_UP_LOCATION);
        pickUpLocation.sendKeys("Rīga");
        baseFunctions.pleaseWaitElement(PICK_UP_LOCATION_LIST);
        pickUpLocation.sendKeys(Keys.ARROW_DOWN);
        pickUpLocation.sendKeys(Keys.ENTER);
        LOGGER.info("Pick up location is selected");
    }

    public void tickCheckBox() {
        baseFunctions.click(LOCATION_CHECK_BOX);
    }

    public void selectDropOffLocation() { // Need help, Xpath in PickUp and in DropOff is the same
        WebElement dropOffLocation = baseFunctions.findElement(DROP_OFF_LOCATION);
        //dropOffLocation.sendKeys("Rig");
        baseFunctions.typeIn(DROP_OFF_LOCATION, "Rīg");
        WebElement dropOffLocationWait = baseFunctions.findElement(DROP_OFF_LOCATION).findElement(DROP_OFF_LOCATION_LIST);
        baseFunctions.pleaseWaitElements(dropOffLocationWait);
        dropOffLocation.sendKeys(Keys.ARROW_DOWN);
        dropOffLocation.sendKeys(Keys.ENTER);
        ;
        LOGGER.info("Drop off location is selected");
    }

    public void selectPickUpDate() {
        baseFunctions.click(PICK_UP_DATE);
        baseFunctions.click(PICK_UP_NEXT_MONTH);
        List<WebElement> dates = baseFunctions.findElements(PICK_UP_DATE_LIST);
        dates.get(2).click();
        LOGGER.info("Pick up date is selected");
    }


    public void selectPickUpTime() { // ---------> Need to update this function.
        baseFunctions.click(PICK_UP_TIME);
        List<WebElement> timeBlocks = baseFunctions.findElements(PICK_UP_TIME_LIST);
        timeBlocks.get(0).click();
        LOGGER.info("Pick up time is selected");
    }

    public void selectDropOffDate() {
        baseFunctions.click(DROP_OFF_DATE);
        List<WebElement> dates = baseFunctions.findElements(PICK_UP_DATE_LIST);
        dates.get(9).click();
        LOGGER.info("Drop off date is selected");
    }

    public void selectDropOffTime() {
        baseFunctions.click(DROP_OFF_TIME);
        List<WebElement> timeBlocks = baseFunctions.findElements(PICK_UP_TIME_LIST);
        timeBlocks.get(1).click();
        LOGGER.info("Drop off time is selected");
    }

    public void checkSpecialOffers() {
        String spec_offers_title = baseFunctions.getText(SPECIAL_OFFERS);
        String SPEC_OFFERS_TEXT = "Special offers";
        if (Objects.equals(spec_offers_title, SPEC_OFFERS_TEXT)) {
            LOGGER.info("Special offers are available");
        } else {
            LOGGER.info("! ! ! Special offers are not available");
        }

    }


}
