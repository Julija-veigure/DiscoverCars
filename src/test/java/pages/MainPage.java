package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class MainPage {
    private final Logger LOGGER = (Logger) LogManager.getLogger(this.getClass());
    private BaseFunctions baseFunctions;

    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    private final By LIST_OF_LOCATIONS = By.xpath(".//div[@class = 'tl-box']");
    private final By TITLE = By.xpath(".//h1[@class = 'home-h1 display-small']");
    private final By LATVIA = By.xpath(".//a[@href = 'https://www.discovercars.com/latvia']");
    private final By LANGUAGES = By.xpath(".//a[@data-link = 'choose-language']");
    private final By LANGUAGE_LATVIAN = By.xpath(".//a[@data-iso-code = 'lv']");
    private final By LANGUAGE_ENGLISH = By.xpath(".//a[@data-iso-code = 'en']");
    public String TITLE_TEXT = "Car Rental – Search, Compare, and Save up to 70%!";
    public String titleInEnForLv = "Car Rental in Latvia";
    public String titleInLvForLv = "Auto noma Latvijā";
    public String NUMBER_OF_COUNTRIES = "38";


    public MainPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public void acceptCookies() {
        LOGGER.info("Cookies is accepted");
        baseFunctions.click(ACCEPT_COOKIES_BTN);
    }

    public String giveMainPageTitle() {
        String title = baseFunctions.getText(TITLE);
        LOGGER.info("Main page title is - " + title);
        return title;
    }

    public String giveNumbersOfCountries() {
        LOGGER.info("A total of available countries in the web: " + baseFunctions.findElements(LIST_OF_LOCATIONS).size());
        int numbersOf = baseFunctions.findElements(LIST_OF_LOCATIONS).size();
        return String.valueOf(numbersOf);
    }

    public void selectCountryLatvia() {
        baseFunctions.click(LATVIA);
        LOGGER.info("Country Latvia is selected");
    }

    public void selectLatvianLanguage() {
        baseFunctions.click(LANGUAGES);
        baseFunctions.click(LANGUAGE_LATVIAN);
        LOGGER.info("Latvian language is selected");
    }

    public void selectEnglishLanguage() {
        baseFunctions.click(LANGUAGES);
        baseFunctions.click(LANGUAGE_ENGLISH);
        LOGGER.info("English language is selected");
    }


}
