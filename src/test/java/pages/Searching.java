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

    private final By PICKUP_LOCATION = By.xpath(".//input[@Id = 'pick-up-location']");
    private final By SEARCH_NOW_BTN = By.xpath(".//button[@id = 'location-submit']");
    private final By UNABLE_TO_FIND_LOCATION = By.xpath(".//div[@class = 'not-found-message hide']");
    private final By WARNING_SELECT_LOCATION = By.xpath(".//ul[@class = 'error-list']");
    private final By PICK_UP_DATE = By.xpath(".//input[@id = 'pick-date-ui']");
    private final By PICK_UP_TIME = By.xpath(".//div[@id = 'pick_time_chosen']");
    private final By PICK_UP_TIME_LIST = By.xpath(".//ul[@class = 'chosen-results']");
    private final By PICK_UP_NEXT_MONTH = By.xpath(".//a[@class = 'ui-datepicker-next ui-corner-all']");
    private final By PICK_UP_DATE_LIST = By.xpath(".//a[@class = 'ui-state-default']");
    private final By DROP_OFF_DATE = By.xpath(".//input[@id = 'drop-date-ui']");
    private final By DROP_OFF_TIME = By.xpath(".//div[@id = 'drop_time_chosen']");
    private final By SPECIAL_OFFERS = By.xpath(".//span[@class = 'category-label trend']");
    private String SPEC_OFFERS_TEXT = "Special offers";


    public Searching(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void search() {
        baseFunctions.click(SEARCH_NOW_BTN);
        LOGGER.info("Search now btn ...");
    }

    public String giveWarningMsg() {
        LOGGER.info("Search without location, checking for warning message");
        return baseFunctions.getText(WARNING_SELECT_LOCATION);
    }

    public void selectPickUpLocation() throws InterruptedException {
        WebElement pickUpLocation = baseFunctions.findElement(PICKUP_LOCATION);
        pickUpLocation.sendKeys("Rīga");
        Thread.sleep(4000);
        // TUT MNE NADO PODOZDATJ POKA PODRUZITSJA POMOGI POZALUJSTA, KAK PRAVELNO OZIDANIJE PROPISATJ?
        pickUpLocation.sendKeys(Keys.ARROW_DOWN);
        pickUpLocation.sendKeys(Keys.ENTER);
        LOGGER.info("Pick up location is selected");
    }

    public void selectPickUpDate() {
        baseFunctions.click(PICK_UP_DATE);
        baseFunctions.click(PICK_UP_NEXT_MONTH);
        List<WebElement> dates = baseFunctions.findElements(PICK_UP_DATE_LIST);
        dates.get(2).click();
        LOGGER.info("Pick up date is selected");
    }


    public void selectPickUpTime() { // ---------> Need update this function.
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
        if (Objects.equals(spec_offers_title, SPEC_OFFERS_TEXT)) {
            LOGGER.info("Special offers is available");
        }

    }


}
