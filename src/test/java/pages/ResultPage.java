package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.Objects;

public class ResultPage {
    private final Logger LOGGER = (Logger) LogManager.getLogger(this.getClass());
    private final BaseFunctions baseFunctions;

    private final By CHANGE_SRC_BTN = By.xpath(".//a[@class = 'change-search trigger-gtm-change-search']");
    private final By CLEAR_PICK_UP_LOCATION = By.xpath(".//a[@class= 'clear-auto-complete']");
    public final By SPECIAL_OFFERS = By.xpath(".//span[@class = 'category-label trend']");

    public ResultPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void changeSearchRequest() {
        baseFunctions.click(CHANGE_SRC_BTN);
    }

    public void deletePickUpLocation() {
        baseFunctions.click(CLEAR_PICK_UP_LOCATION);
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
