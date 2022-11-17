import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.Test;
import pages.*;

public class DiscoverCarsTest {
    private final Logger LOGGER = (Logger) LogManager.getLogger(this.getClass());

    @Test

    public void Testing() throws InterruptedException {
        LOGGER.info(" This test will check some functionality in <Discover cars> page");

        BaseFunctions baseFunctions = new BaseFunctions();
        MainPage mainPage = new MainPage(baseFunctions);
        ResultPage resultPage = new ResultPage(baseFunctions);
        Searching searching = new Searching(baseFunctions);
        Login login = new Login(baseFunctions);


        baseFunctions.openUrl("https://www.discovercars.com/");

        mainPage.acceptCookies();

        baseFunctions.pleaseAssert(mainPage.TITLE_TEXT, mainPage.giveMainPageTitle());

        mainPage.giveNumbersOfCountries(); // Logging print out 2 times result - why?
        baseFunctions.pleaseAssert(mainPage.NUMBER_OF_COUNTRIES, mainPage.giveNumbersOfCountries());

        mainPage.selectCountryLatvia(); //not always select Latvia - need to investigate!
        baseFunctions.comparePageTitle(mainPage.titleInEnForLv, mainPage.giveMainPageTitle());

        mainPage.selectLatvianLanguage();
        baseFunctions.comparePageTitle(mainPage.titleInLvForLv, mainPage.giveMainPageTitle());

        mainPage.selectEnglishLanguage();
        baseFunctions.comparePageTitle(mainPage.titleInEnForLv, mainPage.giveMainPageTitle());

        searching.search();
        baseFunctions.pleaseAssert(searching.WARNING_MSG_PICK_UP, searching.giveWarningMsg());

        searching.selectPickUpLocation();
        searching.selectPickUpDate();
        searching.selectPickUpTime();

        searching.tickCheckBox();

        searching.search();
        baseFunctions.pleaseAssert(searching.WARNING_MSG_DROP_OFF, searching.giveWarningMsg());

        //searching.selectDropOffLocation(); //
        searching.tickCheckBox();

        searching.selectDropOffDate();
        searching.selectDropOffTime();

        searching.search();
        searching.loadingAllResults();

        resultPage.checkSpecialOffers();
        resultPage.changeSearchRequest();
        resultPage.deletePickUpLocation();

        login.clickOnLogo();
        login.clickLoginIcon();
        login.closePopUp();
        login.clickLoginIcon();
        login.continueWithGoogle();
        login.typeInEmail();
        login.typeInPassword();
        baseFunctions.pleaseAssert(login.NAME, login.giveAuthorizerName());

        baseFunctions.closeBrowser();

    }
}

