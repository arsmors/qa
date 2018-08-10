package secondTest;

import secondTest.pages.BaseFunc;
import org.junit.Test;
import secondTest.pages.HomePage;
import secondTest.pages.SearchPage;


public class SearchDelfiTest2 {

    BaseFunc baseFunc = new BaseFunc();

    private final String HOME_PAGE = "http://rus.delfi.lv";

    @Test
    public void checkArticleTitle() throws InterruptedException {
        baseFunc.openPage(HOME_PAGE);

        HomePage homePage = new HomePage(baseFunc);

        homePage.search("погода");

        SearchPage searchPage = new SearchPage(baseFunc);
        searchPage.sort();

        Thread.sleep(5000);
        searchPage.clickPageNumber(4);
        Thread.sleep(5000);
        searchPage.datesCheck();

    }
}
