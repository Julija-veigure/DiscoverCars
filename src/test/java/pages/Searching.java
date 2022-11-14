package pages;

import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Searching {
    private final Logger LOGGER = (Logger) LogManager.getLogger(this.getClass());
    private BaseFunctions baseFunctions;

    private final By PICKUP_LOCATION = By.xpath(".//input[@Id = 'pick-up-location']");
    private final By SEARCH_NOW_BTN = By.xpath(".//button[@id = 'location-submit']");
    private final By UNABLE_TO_FIND_LOCATION = By.xpath(".//div[@class = 'not-found-message hide']");
    private final By WARNING_SELECT_LOCATION = By.xpath(".//ul[@class = 'error-list']");
    private final By PICK_UP_DATE = By.xpath(".//input[@id = 'pick-date-ui']");
    private final By PICK_UP_TIME = By.xpath(".//div[@id = 'pick_time_chosen']");


    public Searching(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void search() {
        baseFunctions.click(SEARCH_NOW_BTN);
    }

    public String warningMsg() {
        return baseFunctions.getText(WARNING_SELECT_LOCATION);
    }

    public void selectPickUpLocation() throws InterruptedException {
        WebElement pickUpLocation = baseFunctions.findElement(PICKUP_LOCATION);
        pickUpLocation.sendKeys("Rīga");
        Thread.sleep(2000); //NEED TO CHANGE!!!!
        pickUpLocation.sendKeys(Keys.ARROW_DOWN);
        pickUpLocation.sendKeys(Keys.ENTER);
    }

    public String selectPickUpDate() { //doen't work, doesn't retur tex ?!?!?!
        String text = baseFunctions.getText(PICK_UP_DATE);
        System.out.println(text);
        return text;
    }


}
