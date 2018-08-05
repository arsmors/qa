package firstTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class DelfiCommercialTest {

    private final String HOME_PAGE = "http://rus.delfi.lv";
    private final By TEST_ELEMENT = By.name("gemius_hcconn_1528641288626_7569972");

    @Test
    public void firstTest() {



        WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
        driver.get(HOME_PAGE);

        List<WebElement> listOfElements = new ArrayList<WebElement>();
        //driver.findElements(TEST_ELEMENT);

        listOfElements = driver.findElements(TEST_ELEMENT);
        listOfElements.isEmpty();
        Assert.assertTrue("is not visible", !listOfElements.isEmpty());


        driver.quit();

    }
}
