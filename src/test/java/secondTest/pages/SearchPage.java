package secondTest.pages;

import cucumber.api.java.sl.In;
import cucumber.api.java8.Da;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class SearchPage {
    private final By SORT_BUTTON = By.xpath("//*[@class='gsc-selected-option']");
    private final By SORT_DATE = By.xpath("//*[@class = \"gsc-option-menu-item\"]");
    private final By PAGES = By.xpath("//*[@class = \"gsc-cursor-page\"]");
    private final By DATES_CHECK = By.xpath("//*[@class = \"gs-bidi-start-align gs-snippet\"]");

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

    public int separateDate(List<WebElement> list, int i) {
        int separatedDate = parseInt(list.get(i).getText().substring(0, 2).replace(" ", ""));
        return separatedDate;
    }


    public void datesCheck() {
        List<WebElement> listOfElements2 = new ArrayList<WebElement>();
        listOfElements2 = baseFunc.getElements(DATES_CHECK);
        List<WebElement> all_elements = new ArrayList<WebElement>();
        all_elements.addAll(listOfElements2);

        for (int i = 0; i < all_elements.size() - 1; i++) {

            //         System.out.println(parseInt(all_elements.get(i).getText().substring(0,2).replace(" ","")));

            if (separateDate(all_elements, i) > separateDate(all_elements, i + 1)) {
                //          System.out.println("Current date is bigger than the next");
                break;
            }
        }
    }
}
