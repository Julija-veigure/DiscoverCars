package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class BookNow {
    private final Logger LOGGER = (Logger) LogManager.getLogger(this.getClass());
    private final BaseFunctions baseFunctions;

    public BookNow(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    final private By DRIVER_TITLE = By.id("driverTitle"); //select
    final private By DRIVER_NAME = By.id("driverName");
    final private By DRIVER_LAST_NAME = By.id("driverLastName");
    final private By DRIVER_EMAIL = By.id("driverEmail");
    final private By PHONE_COUNTRY_CODE = By.id("phoneCountryCode");
    final private By PHONE_NUMBER = By.id("driverPhone");
    final private By DAY_OF_BIRTH = By.id("driver_birth_dt_day"); //select
    final private By MONTH_OF_BIRTH = By.id("driver_birth_dt_month"); //select
    final private By YEAR_OF_BIRTH = By.id("driver_birth_dt_year"); //select
    final private By ADD_FLIGHT_NUMBER = By.xpath(".//a[@data-view = 'flight-number']");
    final private By FLIGHT_NUMBER = By.id("driverFlightNr");
    final private By ADD_DRIVER_COMMENT = By.xpath(".//a[@data-view = 'comment']");
    final private By DRIVER_COMMENT = By.id("driverComment");
    final private By BOOK_NOW_BTN = By.id("createReservation");


    public void takeReservation() {
        baseFunctions.selectByValue(DRIVER_TITLE, "ms");
        baseFunctions.typeIn(DRIVER_NAME, "Test");
        baseFunctions.typeIn(DRIVER_LAST_NAME, "Selenium");
        baseFunctions.typeIn(DRIVER_EMAIL, "discover.cars.for.tests@gmail.com");
        baseFunctions.typeIn(PHONE_COUNTRY_CODE, "+371");
        baseFunctions.typeIn(PHONE_NUMBER, "22222222");
        baseFunctions.selectByIndex(DAY_OF_BIRTH, 18);
        baseFunctions.selectByIndex(MONTH_OF_BIRTH, 8);
        baseFunctions.selectByValue(YEAR_OF_BIRTH, "1979");
        baseFunctions.click(ADD_FLIGHT_NUMBER);
        baseFunctions.typeIn(FLIGHT_NUMBER, "QQ99999999");
        baseFunctions.click(ADD_DRIVER_COMMENT);
        baseFunctions.typeIn(DRIVER_COMMENT, "This is not a real reservation, this is a TEST");
        baseFunctions.click(BOOK_NOW_BTN);
        LOGGER.info("Information about driver is filled in and car is booked!");
    }

}
