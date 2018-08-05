package secondTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import secondTest.pages.BaseFunc;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SearchDelfiTest {
    WebDriver driver;

    private final String HOME_PAGE = "http://rus.delfi.lv";
    private final By SEARCH_FIELD = By.xpath("//*[@class='headerSearchInput']");
    private final By SEARCH_FIELD_SEND = By.xpath("//*[@class='headerSearchInputBtn']");
    private String slovo1 = "погода";
    private final By SORT_BUTTON = By.xpath("//*[@class='gsc-selected-option']");
    private final By SORT_DATE = By.xpath("//*[@class = \"gsc-option-menu-item\"]");
    private final By PAGES = By.xpath("//*[@class = \"gsc-cursor-page\"]");
    private final By DATES_CHECK = By.xpath("//*[@class = \"gs-bidi-start-align gs-snippet\"]");


    @Test
    public void checkSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/arsensmorins/Desktop/QA2/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);

        WebElement element = driver.findElement(SEARCH_FIELD);

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(slovo1);
        actions.build().perform();

        driver.findElement(SEARCH_FIELD_SEND).click();

        driver.findElement(SORT_BUTTON).click();

        Thread.sleep(5000);
        driver.findElement(SORT_DATE).click();


        List<WebElement> listOfElements = new ArrayList<WebElement>();
        listOfElements = driver.findElements(PAGES);
        listOfElements.get(5).click();

        List<WebElement> listOfElements2 = new ArrayList<WebElement>();
        listOfElements2 = driver.findElements(DATES_CHECK);




    }
}


