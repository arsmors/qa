package secondTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebElement driver;
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
