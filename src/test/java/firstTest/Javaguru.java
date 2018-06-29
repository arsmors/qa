package firstTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;


public class Javaguru {

    private final String HOME_PAGE = "http://javaguru.lv";
    private final String COURSE_NAME = "Курс PHP";
    private final By PATH = By.xpath(".//*[@class = 'menuAcourse']/span");

    @Test
    public void checkElement() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);

      //  driver.findElements(PATH);

        Boolean isCoursefound = false;
        List<WebElement> listOfElements = new ArrayList<WebElement>();
        listOfElements = driver.findElements(PATH);
        for (int i = 0; i < listOfElements.size() ; i++) {
            if (listOfElements.get(i).getText().equals(COURSE_NAME)) {
                isCoursefound = true;
                break;
            }
        }

        Assert.assertTrue("No menu item is found", isCoursefound);
    }

}
