package firstTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class Ishop2 {

    WebDriver driver;
    private final String HOME_PAGE = "http://automationpractice.com/";
    private final By MAIN = By.xpath(".//*[@class=\"sf-menu clearfix menu-content sf-js-enabled sf-arrows\"]/li/a");
    private final By FILTER_ITEM = By.xpath("//ul[@class=\"col-lg-12 layered_filter_ul\"]/li/label");
    private final By COLORS = By.xpath("//ul[@class=\"col-lg-12 layered_filter_ul color-group\"]/li/label");
    private final By LOADER = By.xpath("//ul[@class=\"product_list grid row\"]/p");

    private final Logger LOGGER = LogManager.getLogger(Ishop2.class);

    @Test
    public void checkElement() throws InterruptedException {
        LOGGER.info("Setting Gecko global property");
        System.setProperty("webdriver.chrome.driver", "/Users/arsensmorins/Desktop/QA2/chromedriver");


        LOGGER.info("Open Browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LOGGER.info("Opening Home Page");
        driver.get(HOME_PAGE);

        selectMenuItem("WOMEN");
        selectFilterItem("Dresses", FILTER_ITEM);
        Boolean dynamicElement = (new WebDriverWait(driver, 10)) .until(ExpectedConditions.invisibilityOfElementLocated(LOADER));

        selectFilterItem("Orange", COLORS);

    }

    private void selectMenuItem(String item) {
        List<WebElement> menuItems = driver.findElements(MAIN);
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getText().equals(item)) {
                menuItems.get(i).click();
                break;
            }
        }
    }

    private void selectFilterItem(String filterName, By locator) {
        List<WebElement> filterItems = driver.findElements(locator);
        for (int i = 0; i < filterItems.size(); i++) {
            if (filterItems.get(i).getText().contains(filterName)) {
                filterItems.get(i).click();
                break;
            }
        }
    }
}