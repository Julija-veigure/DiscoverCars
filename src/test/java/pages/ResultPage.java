package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ResultPage {
    private final Logger LOGGER = (Logger) LogManager.getLogger(this.getClass());
    private final BaseFunctions baseFunctions;

    private final By CHANGE_SRC_BTN = By.xpath(".//a[@class = 'change-search trigger-gtm-change-search']");
    private final By CLEAR_PICK_UP_LOCATION = By.xpath(".//a[@class= 'clear-auto-complete']");


    public ResultPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void changeSearchRequest() {
        baseFunctions.click(CHANGE_SRC_BTN);
    }

    public void deletePickUpLocation() {
        baseFunctions.click(CLEAR_PICK_UP_LOCATION);
    }


}
