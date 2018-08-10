package secondTest.pages;

import cucumber.api.java.sl.In;
import cucumber.api.java8.Da;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public void datesCheck() {
        List<WebElement> listOfElements2 = new ArrayList<WebElement>();
        listOfElements2 = baseFunc.getElements(DATES_CHECK);
        List<String> all_elements = new ArrayList<String>();

        for (int i = 0; i < listOfElements2.size(); i++) {
            all_elements.add(listOfElements2.get(i).getText().substring(0, 2));
//            listOfElements2.get(i).getText();
//            listOfElements2.get(i+1).getText();
//            all_elements.get(i);
//            all_elements.get(i+1);
            System.out.println(all_elements.get(i));


////            int position1 = Integer.parseInt(all_elements.get(i));
////            int position2 = Integer.parseInt(all_elements.get(i+1));
//            System.out.println();


            //   for (WebElement e : listOfElements2) {
            // all_elements.add(e.getText().substring(0, 2));
            //    listOfElements2.get(e).getText();
            //     listOfElements2.get(e+1).getText();
            //      int position2 = Integer.parseInt(all_elements.get(1));
            //      System.out.println(position1);
            //    System.out.println(position2);
        }
    }
}


//        for (int i = 0; i < listOfElements2.size(); i++) {
//            String aa = listOfElements2.get(i).getText();
//            i++;
//
//        }
