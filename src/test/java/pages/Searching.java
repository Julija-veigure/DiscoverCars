package pages;

import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Searching {
    private final Logger LOGGER = (Logger) LogManager.getLogger(this.getClass());
    private final BaseFunctions baseFunctions;

    private final By UNABLE_TO_FIND_LOCATION = By.xpath(".//div[@class = 'not-found-message hide']");
    public String UNABLE_TO_FIND_ANY_LOCATION = "Unable to find any location";
    public final By SEARCH_NOW_BTN = By.xpath(".//button[@id = 'location-submit']");
    private final By WARN_MSG = By.xpath(".//ul[@class = 'error-list']");
    public String WARNING_MSG_PICK_UP = "Select a pick-up location";
    public final By PICK_UP_LOCATION = By.xpath(".//input[@Id = 'pick-up-location']");
    public final By PICK_UP_LOCATION_LIST = By.xpath(".//div[@class= 'location-item airport tt-suggestion tt-selectable']");
    private final By PICK_UP_DATE = By.xpath(".//input[@id = 'pick-date-ui']");
    public final By PICK_UP_TIME_FIELD = By.xpath(".//div[@id = 'pick_time_chosen']");
    public final By TIME_LIST = By.xpath(".//li[@class = 'active-result']");
    private final By PICK_UP_TIME = By.xpath(".//li[@data-option-array-index= '3']");
    private final By PICK_UP_NEXT_MONTH = By.xpath(".//a[@class = 'ui-datepicker-next ui-corner-all']");
    private final By DATE_LIST = By.xpath(".//a[@class = 'ui-state-default']");
    private final By LOCATION_CHECK_BOX = By.xpath(".//label[@for = 'is-drop-off']");
    public String WARNING_MSG_DROP_OFF = "Select a drop-off location";
    private final By DROP_OFF_LOCATION = By.xpath(".//input[@id= 'drop-off-location']");
    private final By DROP_OFF_LOCATION_LIST = By.xpath(".//div[@class= 'location-item airport tt-suggestion tt-selectable']");
    private final By DROP_OFF_DATE = By.xpath(".//input[@id = 'drop-date-ui']");
    private final By DROP_OFF_TIME = By.xpath(".//div[@id = 'drop_time_chosen']");
    public final By ADDITIONAL_FILTERS = By.xpath(".//div[@class = 'col-3 col-3-pr-10']");


    public Searching(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void search() {
        baseFunctions.click(SEARCH_NOW_BTN);
        LOGGER.info("Search now btn ...");
    }

    public void loadingAllResults() {
        baseFunctions.click(SEARCH_NOW_BTN);
        baseFunctions.pleaseWaitElement(ADDITIONAL_FILTERS);
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
       // baseFunctions.selectDropdown(DROP_OFF_LOCATION, "a Downtown");
/*
        WebElement dropOffLocationWait = baseFunctions.findElement(DROP_OFF_LOCATION).findElement(DROP_OFF_LOCATION_LIST);
        baseFunctions.pleaseWaitElements(dropOffLocationWait);
        dropOffLocation.sendKeys(Keys.ARROW_DOWN);
        dropOffLocation.sendKeys(Keys.ENTER);*/
        LOGGER.info("Drop off location is selected");
    }

    public void selectPickUpDate() {
        baseFunctions.click(PICK_UP_DATE);
        baseFunctions.click(PICK_UP_NEXT_MONTH);
        baseFunctions.findElements(DATE_LIST).get(2).click();
        LOGGER.info("Pick up date is selected");
    }


    public void selectPickUpTime() { // ---------> Need to update this function.
        baseFunctions.click(PICK_UP_TIME_FIELD);
        baseFunctions.findElements(TIME_LIST).get(13).click();
        LOGGER.info("Pick up time is selected");
    }

    public void selectDropOffDate() {
        baseFunctions.click(DROP_OFF_DATE);
        baseFunctions.findElements(DATE_LIST).get(9).click();
        LOGGER.info("Drop off date is selected");
    }

    public void selectDropOffTime() {
        baseFunctions.click(DROP_OFF_TIME);
        baseFunctions.findElements(TIME_LIST).get(51).click();
        LOGGER.info("Drop off time is selected");
    }


}
