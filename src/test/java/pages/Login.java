package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login {
    private final Logger LOGGER = (Logger) LogManager.getLogger(this.getClass());

    private BaseFunctions baseFunctions;

    private final By LOGO = By.xpath(".//div[@class = 'logo']");
    private final By LOGIN_ICON = By.xpath(".//a[@data-label = 'Navigation']");
    private final By CLOSE_LOGIN_WITH_GOOGLE = By.xpath(".//div[@class = 'modal-close']");
    private final By CONTINUE_WITH_GOOGLE = By.xpath(".//a[@class = 'button button-outline button-md mt-20 pointer']");
    private final By EMAIL_ADDRESS = By.id("identifierId");
    private final String EMAIL_TEXT = "discover.cars.for.tests@gmail.com";
    private final String PASSWORD_TEXT = "IwantCabriolet1=";
    private final By NEXT = By.xpath(".//span[@jsname = 'V67aGc']");
    private final By PASSWORD = By.xpath(".//input[@name = 'password']");
    private final By SHOW_PASSWORD = By.xpath(".//div[@class= 'sSzDje NEk0Ve']");
    private final By ACCOUNT_NAME = By.xpath(".//span[@class = 'trimmed-name']");
    public final String NAME = "discover.cars.for.tests";

    public Login(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void clickOnLogo() {
        baseFunctions.click(LOGO);
        LOGGER.info("Clicking on the logo changed the location to the main page");
    }

    public void clickLoginIcon() {
        baseFunctions.click(LOGIN_ICON);
        LOGGER.info("Click on the Login btn");
    }

    public void closePopUp() {
        baseFunctions.click(CLOSE_LOGIN_WITH_GOOGLE);
        LOGGER.info("Close popup, we don't want to log in by google account");
    }

    public void continueWithGoogle() {
        baseFunctions.click(CONTINUE_WITH_GOOGLE);
        LOGGER.info("Transfer to the Google login");
    }

    public void typeInEmail() {
        baseFunctions.typeIn(EMAIL_ADDRESS, EMAIL_TEXT);
        baseFunctions.findElements(NEXT).get(1).click();
        LOGGER.info("Email - discover.cars.for.tests@gmail.com  is accepted");
    }

    public void typeInPassword() {
        baseFunctions.click(PASSWORD);
        baseFunctions.typeIn(PASSWORD, PASSWORD_TEXT);
        baseFunctions.findElements(NEXT).get(1).click();
        LOGGER.info("Password - *** - accepted");
    }

    public String giveAuthorizerName() {
        baseFunctions.pleaseWaitElement(ACCOUNT_NAME);
        LOGGER.info("Congratulation, you are authorized");
        return baseFunctions.getText(ACCOUNT_NAME);

    }


}
