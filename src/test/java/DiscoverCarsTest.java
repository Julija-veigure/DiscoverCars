import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.Test;
import pages.*;

public class DiscoverCarsTest {
    private final Logger LOGGER = (Logger) LogManager.getLogger(this.getClass());

    @Test

    public void Testing() throws InterruptedException {
        LOGGER.info(" This test will check some functionality");

        BaseFunctions baseFunctions = new BaseFunctions();
        MainPage mainPage = new MainPage(baseFunctions);
        Searching searching = new Searching(baseFunctions);
        Login login = new Login(baseFunctions);


        baseFunctions.openUrl("https://www.discovercars.com/");

        mainPage.acceptCookies();

        baseFunctions.compare(mainPage.title, mainPage.giveMainPageTitle());
        mainPage.giveNumbersOfCountries();
        baseFunctions.compare(mainPage.numberOfCountries, mainPage.giveNumbersOfCountries());

        mainPage.selectCountryLatvia();
        baseFunctions.compare(mainPage.titleInEnForLv, mainPage.giveMainPageTitle());
        mainPage.selectLatvianLanguage();
        baseFunctions.compare(mainPage.titleInLvForLv, mainPage.giveMainPageTitle());
        mainPage.selectEnglishLanguage();
        baseFunctions.compare(mainPage.titleInEnForLv, mainPage.giveMainPageTitle());

        searching.search();
        baseFunctions.compare(mainPage.warningMsg, searching.giveWarningMsg());

        searching.selectPickUpLocation();
        searching.selectPickUpDate();
        searching.selectPickUpTime();

        searching.selectDropOffDate();
        searching.selectDropOffTime();

        searching.search();

        login.clickLoginIcon();
        login.closePopUp();

        baseFunctions.closeBrowser();

    }
}

