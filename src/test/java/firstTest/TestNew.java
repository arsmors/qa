package firstTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TestNew {

    private final String HOME_PAGE = "http://rus.delfi.lv";
    private final String STRING_NAME = "ФОТО. Секреты подводной фотосессии: как девушка из Резекне стала русалкой";
    private final By PATH = By.xpath(".//*[@class = 'top2012-title']");

    @Test
    public void checkElement() {
        System.setProperty("webdriver.chrome.driver", "/Users/arsensmorins/Desktop/QA2/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);

        Boolean isStringFound = false;
        List<WebElement> listOfElements = new ArrayList<WebElement>();
        listOfElements = driver.findElements(PATH);
        for (int i = 0; i < listOfElements.size() ; i++) {
            if (listOfElements.get(i).getText().equals(STRING_NAME)) {
                isStringFound = true;
                break;
            }
        }

        Assert.assertTrue("No String item is found", isStringFound);
    }
}
