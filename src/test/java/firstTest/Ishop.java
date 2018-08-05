package firstTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ishop {

    private final String HOME_PAGE = "http://automationpractice.com/";
    private final By WOMAN = By.xpath("//*[@title=\"Women\"]");
    private final By DRESSES = By.xpath("//*[@for=\"layered_category_8\"]");
    private final By ORANGE = By.xpath("//*[@name=\"layered_id_attribute_group_13\"]");
    private final By CONTINUESHOPPING = By.xpath("//*[@class=\"button-container\"]/span");
    private final By PROCEEDTOCHECKOUT = By.xpath("//*[@title=\"Proceed to checkout\"]");
    private final By ADDTOCART = By.xpath("//*[@title=\"Add to cart\"]/span");
    private final By TOTALPRICEWITHOUTTAX = By.xpath("//*[@id=\"total_price_without_tax\"]");
    private final By TOTALPRICE = By.xpath("//*[@id=\"total_price_container\"]/span");

    @Test
    public void checkElement() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/arsensmorins/Desktop/QA2/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);
        driver.findElement(WOMAN).click();
        driver.findElement(DRESSES).click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(5000);
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // WebElement dynamicElement = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(ADDTOCART));
        driver.findElement(ORANGE).click();

        List<WebElement> listOfElements = new ArrayList<WebElement>();
        listOfElements = driver.findElements(ADDTOCART);
        listOfElements.get(0).click();

        Thread.sleep(5000);
        driver.findElement(CONTINUESHOPPING).click();

        Thread.sleep(5000);

        List<WebElement> listOfElements2 = new ArrayList<WebElement>();
        listOfElements2 = driver.findElements(ADDTOCART);
        listOfElements2.get(1).click();

        Thread.sleep(5000);
        driver.findElement(PROCEEDTOCHECKOUT).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);

        WebElement element1 = driver.findElement(TOTALPRICE);
        WebElement element2 = driver.findElement(TOTALPRICEWITHOUTTAX);

        boolean result = element1.getText().equals(element2.getText());


        Assert.assertTrue("Price is not equals", result);


    }
}
