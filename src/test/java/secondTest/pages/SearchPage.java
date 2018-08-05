package secondTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    private final By SORT_BUTTON = By.xpath("//*[@class='gsc-selected-option']");
    private final By SORT_DATE = By.xpath("//*[@class = \"gsc-option-menu-item\"]");
    private final By PAGES = By.xpath("//*[@class = \"gsc-cursor-page\"]");

    BaseFunc baseFunc;

    public SearchPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void sort() {
        baseFunc.getElement(SORT_BUTTON).click();
        baseFunc.getElement(SORT_DATE).click();
    }

    public WebElement clickPageNumber(Integer id) {
        List<WebElement> listOfElements = new ArrayList<WebElement>();
        listOfElements = baseFunc.getElements(PAGES);
        listOfElements.get(id).click();
        return listOfElements.get(id);
    }
}
