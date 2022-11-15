package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseFunctions {

    private final Logger LOGGER = (Logger) LogManager.getLogger(this.getClass());
    private WebDriver driver;
    private WebDriverWait wait;


    public BaseFunctions() {
        WebDriverManager.chromedriver().setup();
        LOGGER.info("Opening browser window");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void pleasewait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void loadingData() throws InterruptedException {
        Thread.sleep(4000);
    }

    public void openUrl(String url) {
        LOGGER.info("Opening " + url + " web page");
        driver.get(url);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
    // need to transfer function acceptCookies to MainPage

    public String getText(By locator) {

        return driver.findElement(locator).getText();
    }

    public void compare(String expectedText, String textFromWeb) {
        LOGGER.info("Assertion " + expectedText);
        Assertions.assertEquals(expectedText, textFromWeb, "Asserting fail");
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        LOGGER.info("Getting all elements by " + locator);
        return driver.findElements(locator);
    }

/*    public void selectPickUpLocation(By locator, String text) {
        WebElement inputField = driver.findElement(locator);
        inputField.click();
        inputField.sendKeys(text);
    }*/

    public void closeBrowser() {
        LOGGER.info("Test done!");
        driver.quit();
    }


}
