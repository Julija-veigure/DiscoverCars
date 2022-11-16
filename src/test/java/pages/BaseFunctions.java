package pages;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void loadingData() throws InterruptedException {
        Thread.sleep(6000);
    }

    public void openUrl(String url) {
        LOGGER.info("Opening " + url + " web page");
        driver.get(url);
    }

    public void click(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
        //LOGGER.info("Click on " + locator);
    }

    public String getText(By locator) {
        //LOGGER.info("Getting text from " + locator );
        return driver.findElement(locator).getText();
    }

    public void compare(String expectedText, String textFromWeb) {
        LOGGER.info("Assertion - " + "Expected: " + expectedText + " & Actual: " +  textFromWeb);
        Assertions.assertEquals(expectedText, textFromWeb, "Asserting is failed");
    }

    public WebElement findElement(By locator) {
        //LOGGER.info("Getting element by " + locator);
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        //LOGGER.info("Getting all elements by " + locator);
        return driver.findElements(locator);
    }

    public void closeBrowser() {
        LOGGER.info("Test done!");
        driver.quit();
    }


}
