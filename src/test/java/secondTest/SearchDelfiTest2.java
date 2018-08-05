package secondTest;

import secondTest.pages.BaseFunc;
import org.junit.Test;
import secondTest.pages.HomePage;
import secondTest.pages.SearchPage;


public class SearchDelfiTest2 {

    BaseFunc baseFunc = new BaseFunc();

    private final String HOME_PAGE = "http://rus.delfi.lv";

    @Test
    public void checkArticleTitle() {
        baseFunc.openPage(HOME_PAGE);

        HomePage homePage = new HomePage(baseFunc);

        homePage.search("погода");

        SearchPage searchPage = new SearchPage(baseFunc);
        searchPage.sort();
        searchPage.clickPageNumber(5);
    }
}
