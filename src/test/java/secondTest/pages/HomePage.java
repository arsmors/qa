package secondTest.pages;

import firstTest.Ishop2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    WebElement driver;
    private final Logger LOGGER = LogManager.getLogger(Ishop2.class);

    private final By SEARCH_FIELD = By.xpath("//*[@class='headerSearchInput']");
    private final By SEARCH_FIELD2 = By.name("q");
    private final By SEARCH_FIELD_SEND = By.xpath("//*[@class='headerSearchInputBtn']");

    BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void search(String toSearch) {
        baseFunc.getElement(SEARCH_FIELD2).sendKeys(toSearch);
        baseFunc.getElement(SEARCH_FIELD_SEND).click();
        SearchPage searchPage = new SearchPage(baseFunc);
    }
}
