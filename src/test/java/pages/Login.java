package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class Login {
    private final Logger LOGGER = (Logger) LogManager.getLogger(this.getClass());

    private BaseFunctions baseFunctions;

    private final By LOGIN_ICON = By.xpath(".//a[@data-label = 'Navigation']");
    private final By CLOSE_LOGIN_WITH_GOOGLE = By.xpath(".//div[@class = 'modal-close']");

    public Login(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void clickLoginIcon() {
        baseFunctions.click(LOGIN_ICON);
        LOGGER.info("Click on Login btn");
    }

    public void closePopUp() {
        baseFunctions.click(CLOSE_LOGIN_WITH_GOOGLE);
        LOGGER.info("Close popup, we don't want to log in by google account");
    }





}
