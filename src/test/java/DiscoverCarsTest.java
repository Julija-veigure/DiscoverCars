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
        AttributesForAsserting attributesForAsserting = new AttributesForAsserting(baseFunctions);
        MainPage mainPage = new MainPage(baseFunctions);
        Searching searching = new Searching(baseFunctions);
        Login login = new Login(baseFunctions);


        baseFunctions.openUrl("https://www.discovercars.com/");

        mainPage.acceptCookies();

        baseFunctions.compare(attributesForAsserting.title, mainPage.giveMainPageTitle());
        mainPage.giveNumbersOfCountries();
        baseFunctions.compare(attributesForAsserting.numberOfCountries, mainPage.giveNumbersOfCountries());

        mainPage.selectCountryLatvia();
        baseFunctions.compare(attributesForAsserting.titleInEnForLv, mainPage.giveMainPageTitle());
        mainPage.selectLatvianLanguage();
        baseFunctions.compare(attributesForAsserting.titleInLvForLv, mainPage.giveMainPageTitle());
        mainPage.selectEnglishLanguage();
        baseFunctions.compare(attributesForAsserting.titleInEnForLv, mainPage.giveMainPageTitle());

        searching.search();
        baseFunctions.compare(attributesForAsserting.warningMsg, searching.warningMsg());
        searching.selectPickUpLocation();

        searching.selectPickUpDate();
        searching.selectPickUpTime();

        searching.selectDropOffDate();
        searching.selectDropOffTime();

        searching.search();

        login.clickLoginIcon();



        //baseFunctions.closeBrowser();





        /*tvNetHomePage.acceptCookies();
        String homePageTitle = tvNetHomePage.getArticleTextById(2);
        int commentsHomePage = tvNetHomePage.getCommCount();*/
    }
}

